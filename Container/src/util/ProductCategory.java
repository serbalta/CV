/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package util;

public enum ProductCategory {
	BEVERAGE("beverage"), DEFAULT("default"), FOOD("food") ;
	
	
	private String label;


		private ProductCategory(String label) {
			// TODO Auto-generated constructor stub
				this.label = label;
		} 
	
	
	public String getLabel(){
		return this.label;
	}
	
	
	
	
}
