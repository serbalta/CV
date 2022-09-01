/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package domain.product;

import domain.copy.*;

public abstract class Product implements IProduct, IDeepCopy {
	private String name;
	private float price;

	Product(String name) {
		this.name = name;

	}

	Product(String name, float price) {
		this.name = name;
		this.price = price;

	}

	public abstract Product deepCopy();

	public String getName() {

		return this.name;
	}

	public float getPrice() {

		return this.price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) throws IllegalArgumentException {
		this.price = price;

	}

	public String toString() {
		return "[name =" + this.getName() + "," + "price =" + this.getPrice() + "]";
	}

	

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}


	
	
}
