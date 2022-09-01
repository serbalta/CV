/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package util.searchable;

import java.util.Collection;


public interface ISearchableByFilter<T>  {

	
	public Collection<T> searchByFilter(ISearchFilter filter, Object compareObject);
}
