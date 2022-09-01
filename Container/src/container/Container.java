/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */

package container;

import java.util.Collection;
import java.util.Iterator;

import util.searchable.ISearchFilter;
import util.searchable.ISearchableByFilter;

/**
 * This class handles a simple linked list of {@link IContainerElement}s. It
 * implements the {@link java.util.Collection} interface and provides
 * implementation for its methods. Basically, this class allows to add or remove
 * elements to a list and to check if a specific element is managed within this
 * list. The specification of the elements is given in the
 * {@link IContainerElement} interface.
 * <p>
 * In addition, this class also provides an implementation for the
 * {@link ISearchableByFilter} interface. This means, that the list can be
 * filtered by an {@link ISearchFilter}.
 * <p>
 * The {@link Container} <b>does not</b> allow insertion of <tt>NULL</tt>
 * elements.
 * 
 * @author OOP
 *
 * @param <E>
 *            determines the type of the {@link IContainerElement}s contained in
 *            the {@link Container} and is set during instantiation.
 */
public class Container<E> implements Collection<E>, ISearchableByFilter<E> {

	// TODO: Add attributes according to the class diagram.
	private IContainerElement<E> firstElement;

	private static int size;

	/**
	 * Default Constructor of the Container. The first {@link IContainerElement}
	 * is set to <tt>NULL</tt>.
	 */
	public Container() {
		this.firstElement = null;
	}

	public IContainerElement<E> getFirstElement() {
		return firstElement;
	}

	public void setFirstElement(IContainerElement<E> firstElement) {
		this.firstElement = firstElement;
	}

	@Override
	public boolean add(E e) {
		// TODO:
		boolean i = false;

		if (firstElement == null) {
			firstElement = new ContainerElement<E>(e, firstElement);
			size++;
			i = true;
		} else {
			IContainerElement<E> temp = new ContainerElement<E>(e, null);
			IContainerElement<E> current = firstElement;

			while (current.getNextElement() != null) {

				current = current.getNextElement();

			}

			current.setNextElement(temp);
			size++;
			i = true;

			return i;

		}

		return i;

	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean i = false;

		for (E items : c) {
			if (add(items) == true) {
				i = true;
			}
		}

		return i;
	}

	@Override
	public void clear() {
		firstElement = null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO:
		IContainerElement<E> cursor = firstElement;
		while (cursor != null) {
			if (cursor.equals(o))
				return true;
			cursor = cursor.getNextElement();

		}

		return false;

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO:
		for (Object objects : c) {
			if (contains(objects) == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This methods returns the data of the {@link IContainerElement} at a
	 * specific position in the linked list. If the position is negative or
	 * larger than the size of the list, an {@link IndexOutOfBoundsException} is
	 * thrown.
	 * 
	 * @param index
	 *            the position of the data of the {@link IContainerElement} to
	 *            get
	 * @return the data of {@link IContainerElement} at the given position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds (meaning the index is negative
	 *             or the size of the list is smaller than the index), an
	 *             {@link IndexOutOfBoundsException} is thrown
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO:

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();

		}
		if (firstElement == null) {

			return null;
		}
		IContainerElement<E> current = firstElement;

		for (int i = 0; i < index; i++) {

			current = current.getNextElement();
		}

		return current.getData();

	}

	@Override
	public boolean isEmpty() {
		// TODO:
		if (firstElement == null)
			return true;
		else
			return false;

	}

	@Override
	public Iterator<E> iterator() {
		return new Itr<E>(firstElement);
	}

	@Override
	public boolean remove(Object o) {
		// TODO:
		
		if (firstElement == null)
			throw new RuntimeException("cannot delete");



		IContainerElement<E> cur = firstElement;
		IContainerElement<E> prev = null;

		while (cur != null && !cur.getData().equals(o)) {
			prev = cur;
			cur = cur.getNextElement();
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");


		if(prev == null){
			firstElement = cur.getNextElement();
			return true;
		}
		prev.setNextElement(cur.getNextElement());
		cur.setNextElement(null);
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean i = false;
		
		
		for(Object e : c) {
			IContainerElement<E> temp = this.firstElement;
			E temp1 = (E) e;
			if(temp1 != null && temp1.equals(temp.getData())){
				
				remove(temp1);
				temp = temp.getNextElement();
				
			}
		}
		return i;

	}

	/**
	 * This method is not supported and throws an
	 * {@link UnsupportedOperationException}.
	 *
	 * @throws UnsupportedOperationException
	 *             Not supported by Container
	 * 
	 */
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not supported by Container");
	}

	@Override
	public int size() {
		// TODO:
		if (this.size > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return size;
		}
	}

	/**
	 * This method throws an {@link UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             Not supported
	 * 
	 */
	public Object[] toArray() {
		throw new UnsupportedOperationException("Not supported by Container");
	}

	/**
	 * This method throws an {@link UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             Not supported
	 * 
	 */
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("Not supported by Container");
	}

	@Override
	public String toString() {
		// TODO:
		StringBuffer result = new StringBuffer();
		for (Object x : this)
			result.append(x + " ");

		return result.toString();
	}

	/*
	 * The {@link ISearchableByFilter#searchByFilter} method is called on each
	 * {@link IContainerElement} of the list and all matches are collected in a
	 * {@link Collection}. If the first {@link IContainerElement} of the list is
	 * <tt>NULL</tt>, an empty {@link Collection} is returned. <p> {@inheritDoc}
	 * 
	 */
	public Collection<E> searchByFilter(ISearchFilter filter, Object filterObject) {
		// // TODO:
		Collection<IContainerElement<E>> temp = new Container<IContainerElement<E>>();
			
		if(this.firstElement == null)
		{
			temp.clear();
			return (Collection<E>) temp;
		}
		for(Object x : this){
				
				
				if(filter.searchFilterFunction(this, x) && this.firstElement !=null){
					temp.add((IContainerElement<E>) x);
					
				}
				
				
			}
		return (Collection<E>) temp;
	}

}
