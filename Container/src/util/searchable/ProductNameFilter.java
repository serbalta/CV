/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
	package util.searchable;

import domain.product.Product;

public class ProductNameFilter implements ISearchFilter {
	
	public ProductNameFilter() {

	}

	@Override
	public boolean searchFilterFunction(Object originalObject, Object compareObject) {
		// TODO Auto-generated method stub
		
		
		if (originalObject.getClass() == compareObject.getClass() && originalObject.toString().toUpperCase().equals(compareObject.toString().toUpperCase())) {
			
			return true;

		}
		if (originalObject instanceof Product && !(compareObject instanceof Product)) {
			if (((Product)originalObject).getName().toUpperCase().equals(compareObject.toString())) {
			
				return true;
			}
		} else {
			if (originalObject == null || compareObject == null ) {
				return false;
			}
		}
		
		return false;
	}

}
