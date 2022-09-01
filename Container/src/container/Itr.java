/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package container;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class allows to navigate through a linked list of
 * {@link IContainerElement}s. It provides an implementation of the
 * {@link java.util.Iterator} interface.
 * 
 * @author OOP
 *
 * @param <E>
 *            determines the type of the {@link Itr}. It has to match the type
 *            of the list that the iterator navigates on.
 */
public class Itr<E> implements Iterator<E> {
	// TODO: Add attributes according to the class diagram.

	/**
	 * Constructor that takes a single {@link IContainerElement} that determines
	 * the starting point for the iterator.
	 * 
	 * @param firstElement
	 *            the {@link IContainerElement} the iterator starts navigating
	 *            on
	 */
	
	
	private IContainerElement<E> next;
	
	
	public Itr(IContainerElement<E> firstElement) {
		// TODO:
		this.next = firstElement;
		
		
	}

	@Override
	   public E next() {
       
		if (!hasNext()) throw new NoSuchElementException();
        E res = next.getData();
        next = next.getNextElement();
        return res;
     }


	

	@Override
	public boolean hasNext() {
		return next != null;
		}

	/**
	 * This method throws an {@link UnsupportedOperationException}.
	 * 
	 * @throws UnsupportedOperationException
	 *             Not supported
	 * 
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}