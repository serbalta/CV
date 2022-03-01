package cashregister.ui;

import java.util.Collection;

import cashregister.IShoppingCart;
import domain.product.IProduct;
import domain.record.IInvoice;
import domain.record.PaymentTransaction;
import tree.ITree;

public class CashRegisterConsoleUI implements ICashRegisterUI {

	@Override
	public void displayProducts(ITree<IProduct> products) {
		// TODO Auto-generated method stub
		System.out.println(products.generateConsoleView(" "));

	}

	@Override
	public void displayRecords(Collection<IInvoice> records) {
		// TODO Auto-generated method stub
		int i = 1;

		for (IInvoice r : records) {
			System.out.println("Record " + i++ + ": " + r);
		}
	}

	@Override
	public void displayShoppingCart(IShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		System.out.println("Cart id: " + shoppingCart.getShoppingCartID() + "\nTotal price: "
				+ shoppingCart.getTotalPriceOfElements() + "\nElements: " + shoppingCart.getNumberOfElements());
		
		
	}

	@Override
	public void displayShoppingCarts(Collection<IShoppingCart> shoppingCarts) {
		// TODO Auto-generated method stub
		for (IShoppingCart sc : shoppingCarts) {
			System.out.println("ShoppingCard :" + sc.getShoppingCartID());
		}
	}

	@Override
	public void displayTransaction(PaymentTransaction transaction) {
		// TODO Auto-generated method stub
			System.out.println(transaction);

		

	}

	@Override
	public void pushUpdateInformation(ITree<IProduct> products, Collection<IShoppingCart> carts, Collection<IInvoice> records) {
		// TODO Auto-generated method stub
		
	}

}
