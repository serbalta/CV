/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package util.searchable;

public class TextSearchIgnoreCaseFilter implements ISearchFilter {
	public TextSearchIgnoreCaseFilter() {

	}

	@Override
	public boolean searchFilterFunction(Object originalObject, Object compareObject) {
		// TODO Auto-generated method stub
		if (originalObject.toString().toUpperCase().equals(compareObject.toString().toUpperCase())) {
			return true;
		} else {
			if (originalObject == null || compareObject == null) {
				return false;
			}
			return false;
		}

	}

}
