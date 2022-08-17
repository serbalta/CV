/* 1125266
 * Salih Erbalta
 */


package domain.product;

import java.util.Collection;
import java.util.Vector;

public class JointProduct extends Product {
	private Collection<Product> products = new Vector<Product>();
	
	
	public JointProduct(String name, float price) {
		super(name, price);

	}

	public JointProduct(String name, float price, Collection<Product> products) {
		super(name, price);

	}

	public String toString(){
		 String p ="";
		 for (Product listElements : products){
			 p = p.concat("   "+ Product.class.getSimpleName() + " [name=" +listElements.getName() + ", price=" + listElements.getPrice()+ "]\n");
		 }
		return(this.getClass().getSimpleName()	 + " [name=" +this.getName() + ", price=" + this.getPrice()+ "]\n" + p);
		
	}
	


	public void addProduct(Product product) {
		this.products.add(product);

	}

	public boolean removeProduct(Product product) {

		boolean v = false;

		if (products.contains(product) == true) {
			products.remove(product);
			System.out.println("Product deleted: " + product.getName());
			return v;
		}	
		else {
			return false;
		}
	
	}

	public Collection<Product> getProducts() {
		return products;
	}

}
