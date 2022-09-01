/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package domain.product;

public class SimpleProduct extends Product {
	
	

	public SimpleProduct(String name, float price) {
		super(name ,price);
		
		
	}

	
	public SimpleProduct deepCopy(){
		SimpleProduct sp = new SimpleProduct(this.getName(),this.getPrice());
		if(sp.getClass()==this.getClass())
		{
			
		SimpleProduct sp1 = new SimpleProduct(sp.getName(),sp.getPrice());
		return(sp1);

		}
		else{
			return null;
		}
		
	}
	

}
