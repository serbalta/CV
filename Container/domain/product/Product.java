/* 1125266
 * Salih Erbalta
 */



package domain.product;

public class Product implements IShoppingCartElement {

	private String name = "";
	private float price = 0.0f;
	
	
	public Product(String name, float price) {
		this.setName(name);
		this.setPrice(price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String toString(){
		
		return(this.getClass().getSimpleName()+ "[name=" +this.getName() + ", Price= " + this.getPrice()+ "]\n" );
	}
}
