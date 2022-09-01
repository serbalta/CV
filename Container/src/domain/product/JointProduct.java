/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package domain.product;

import java.util.Collection;
import java.util.Vector;

public class JointProduct extends Product {

	private float discountPercentage;
	private Collection<Product> productslist = new Vector<Product>();

	public JointProduct(String name, float discountPercentage) {
		super(name);
		this.discountPercentage = discountPercentage;
	}

	JointProduct(String name, float discountPercentage, Collection<Product> products) {
		super(name);
		this.discountPercentage = discountPercentage;
		productslist.addAll(products);
	}

	public void addProduct(Product product) {
		if (productslist != null) {
			productslist.add(product);

		}
	}

	public boolean removeProduct(Product product) {

		if (productslist.contains(product)) {
			productslist.remove(product);

		}

		return true;

	}

	public Collection<Product> getProducts() {
		return productslist;
	}

	public float getPrice() {
		float a = 0;
		if (productslist != null) {
			for (Product p : productslist) {
				if (p instanceof JointProduct) {
					a += p.getPrice() * this.discountPercentage;
				}
			}
		}
		return a;
	}

	public JointProduct deepCopy() {
		
		JointProduct jp = new JointProduct(this.getName(), this.getPrice());
		if (jp.getClass() == this.getClass()) {

			JointProduct jp1 = new JointProduct(jp.getName(), jp.getPrice());
			return (jp1);

		} else {
			return null;
		}
	}
	public String toString(){
		return "[name =" + this.getName() + "," + "price =" + this.getPrice() + "]";
	}
}
