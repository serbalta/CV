/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package container;

/**
 * This class holds a single element of the {@link Container} and provides an
 * implementation for the {@link IContainerElement} interface. The typeparameter
 * is used to determine the type of the data stored in the
 * {@link ContainerElement}. It is replaced with the specific type during
 * instantiation.
 * 
 * @author OOP
 *
 * @param <E>
 *            determines the type of the data stored in the
 *            {@link ContainerElement}. The concrete type is set during
 *            instantiation.
 */
public class ContainerElement<E> implements IContainerElement<E> {
	// TODO: Add attributes according to the class diagram.
	private E data;
	private IContainerElement<E> nextElement;

	/**
	 * Constructor that takes a single parameter which specifies the data stored
	 * in the {@link ContainerElement}. The type of the data is determined
	 * during instantiation.
	 * 
	 * @param data
	 *            The data stored in the {@link ContainerElement}
	 */
	public ContainerElement(E data) {
		// TODO:
		this.data = data;
		this.nextElement = null;
	}

	/**
	 * Constructor that takes two arguments (data and next
	 * {@link IContainerElement}). The type is determined during instantiation.
	 * 
	 * @param data
	 *            The data stored in the {@link ContainerElement}
	 * @param next
	 *            The {@link IContainerElement} that should follow the current
	 *            {@link ContainerElement}
	 */
	public ContainerElement(E data, IContainerElement<E> next) {
		// TODO:
		this.data = data;
		nextElement = next;
	}

	public E getData() {
		// TODO:
		return this.data;
	}

	public void setNextElement(IContainerElement<E> next) {
		// TODO:
		this.nextElement = next;

	}

	public boolean hasNextElement() {
		// TODO:

		if (this.nextElement == null) {
			return false;
		} else {
			return true;
		}

	}

	public IContainerElement<E> getNextElement() {
		// TODO:
		IContainerElement<E> temp = null;
		if (this.hasNextElement()) {
			temp = this.nextElement;
			return temp;
		} else {
			return null;
		}
		//return nextElement;
	}

	public String toString() {
		// TODO:
		return data.toString();
	}

}
