/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package domain.product;

public class ExtendedProduct extends SimpleProduct {

	private ExtendedProduct product;
	private ExtendedProduct change;

	public ExtendedProduct(String name, float price) {
		super(name, price);

	}

	public ExtendedProduct(ExtendedProduct product) {
		this(product.getName(), product.getPrice());

	}

	public void setName(String name) {
		change = deepCopy();
		product.setName(name);

	}

	public void setPrice(float price) {
		change = deepCopy();
		product.setPrice(price);

	}

	public ExtendedProduct deepCopy() {
		ExtendedProduct ep = new ExtendedProduct(this);

		return ep;
	}

	public String toString(){
		return "[name =" + this.getName() + "," + "price =" + this.getPrice() + "]";
	}

	public boolean undo() {

		if (change == null) {
			return false;
		} else {
			product = change;
			return true;
		}
	}

}
