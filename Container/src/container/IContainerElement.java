/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package container;

/**
 * This interface specifies the behavior of a single element of a
 * {@link Container}. It takes a single typeparameter to determine the
 * underlying type of the element.
 * 
 * @author OOP
 *
 * @param <E>
 *            determines the type of the {@link IContainerElement}
 */
public interface IContainerElement<E> {
	/**
	 * Sets the next element that follows the current element. In essence the
	 * pointer to the next object is set.
	 * 
	 * @param next
	 *            The next element that follows the current element
	 */
	public void setNextElement(IContainerElement<E> next);

	/**
	 * Checks whether or not other elements are following the current one
	 * 
	 * @return true if another element exists after the current one, false if
	 *         the current element is the last one
	 */
	public boolean hasNextElement();

	/**
	 * Retrieves the next element that follows the current element
	 * 
	 * @return the next element that is connected
	 */
	public IContainerElement<E> getNextElement();

	/**
	 * Retrieves the data of {@link IContainerElement}. Its type is determined
	 * by the typeparemeter <tt>E</tt>.
	 * 
	 * @return the data of the element
	 */
	public E getData();
}
