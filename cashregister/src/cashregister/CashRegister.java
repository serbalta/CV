package cashregister;

import java.util.Collection;

import cashregister.ui.ICashRegisterUI;
import container.Container;
import domain.product.IProduct;
import domain.product.IShoppingCartElement;
import domain.product.Product;
import domain.record.IInvoice;
import domain.record.Invoice;
import domain.record.PaymentTransaction;
import managementserver.ISubjectManagementServer;
import paymentprovider.IPayment;
import tree.ITree;
import tree.node.ITreeNode;
import util.Tuple;
import util.searchable.ProductNameFilter;
import util.searchable.TextSearchIgnoreCaseFilter;

public class CashRegister implements ICashRegister, IObserver {

	private long id;
	private Collection<IInvoice> records;
	private Collection<ICashRegisterUI> uis;
	private ITree<IProduct> products;
	private Collection<Tuple<ISubjectManagementServer, Boolean>> subjects;
	private Collection<IShoppingCart> shoppingCarts;

	public CashRegister(long id) {
		this.id = id;
		this.records = new Container<IInvoice>();
		this.uis = new Container<ICashRegisterUI>();
		this.subjects = new Container<Tuple<ISubjectManagementServer, Boolean>>();
		this.shoppingCarts = new Container<IShoppingCart>();
	}

	@Override
	public void activateNotifications(ISubjectManagementServer subject) {
		// TODO Auto-generated method stub
		boolean changed = false;
		// Tuple<ISubjectManagementServer, Boolean> subj = new
		// Tuple<ISubjectManagementServer, Boolean>(subject, true);
		if (subjects.isEmpty()) {
			subjects.add(new Tuple<ISubjectManagementServer, Boolean>(subject, true) );
		} else {
			for (Tuple<ISubjectManagementServer, Boolean> t : subjects) {
				if (t.getValueA().equals(subject)) {
					t.setValueB(true);
					changed = true;
					break;
				}
				else {
					changed = false;
				}

			}
			if(!changed){
				subjects.add(new Tuple<ISubjectManagementServer, Boolean>(subject, true) );
			}
		}
		System.out.println("Notification has been Activated");

	}

	@Override
	public void deactivateNotifications(ISubjectManagementServer subject) {
		boolean changed = false;
		// Tuple<ISubjectManagementServer, Boolean> subj = new
		// Tuple<ISubjectManagementServer, Boolean>(subject, true);
		if (subjects.isEmpty()) {
			subjects.add(new Tuple<ISubjectManagementServer, Boolean>(subject, false) );
		} else {
			for (Tuple<ISubjectManagementServer, Boolean> t : subjects) {
				if (t.getValueA().equals(subject)) {
					t.setValueB(false);
					changed = true;
					break;
				}
				else {
					changed = false;
				}

			}
			if(!changed){
				subjects.add(new Tuple<ISubjectManagementServer, Boolean>(subject, false) );
			}
		}
		System.out.println("Notification has been Deactivated");

	}

	@Override
	public void notifyChange(ISubjectManagementServer subject) {
		// TODO Auto-generated method stub

		for (Tuple<ISubjectManagementServer, Boolean> t : subjects) {
			if (t.valueA.equals(subject) && t.getValueB() == true) {

				this.products = subject.getChanges();
			}
		}
	}

	private IShoppingCart findShoppingCartById(long id) {
		for (IShoppingCart cart : shoppingCarts) {
			if (cart.getShoppingCartID() == id)
				return cart;
		}

		return null;
	}

	@Override
	public boolean addProductToShoppingCart(long id, IShoppingCartElement element) {
		// TODO Auto-generated method stub
		boolean i = false;
		IShoppingCart isc = findShoppingCartById(id);
		if (shoppingCarts.isEmpty() == false) {
			if (isc != null) {
				isc.addElement(element);
				i = true;
			}
		}

		return i;
	}

	@Override
	public Long addShoppingCart() {
		// TODO Auto-generated method stub
		IShoppingCart isc = ShoppingCartFactory.createShoppingCart();
		shoppingCarts.add(isc);

		return isc.getShoppingCartID();
	}

	@Override
	public void displayProducts() {
		// TODO Auto-generated method stub
		for (ICashRegisterUI ui : uis) {
			ui.displayProducts(products);
		}
	}

	@Override
	public void displayRecords() {
		// TODO Auto-generated method stub
		for (ICashRegisterUI a : uis) {
			if (records != null) {
				a.displayRecords(records);

			} else {
				System.out.println("Records cannot be found.");
			}

		}
	}

	@Override
	public void displayShoppingCart(long id) {
		// TODO Auto-generated method stub
		IShoppingCart c = this.findShoppingCartById(id);

		for (ICashRegisterUI ui : uis) {
			if (c != null) {
				ui.displayShoppingCart(c);
			} else
				System.out.println("There is not Shopping Card.");

		}
	}

	@Override
	public void displayShoppingCarts() {
		// TODO Auto-generated method stub
		for (ICashRegisterUI ui : uis) {
			if (shoppingCarts != null) {
				ui.displayShoppingCarts(shoppingCarts);
			} else
				System.out.println("This Cashregister has not a Shophingcart!");
		}
	}

	@Override
	public long getID() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public Collection<IShoppingCart> getShoppingCarts() {
		// TODO Auto-generated method stub
		return shoppingCarts;
	}

	@Override
	public IInvoice payShoppingCart(long id, IPayment provider) throws ShoppingCartNotFoundException {
		// TODO Auto-generated method stub
		PaymentTransaction pt = null;
		Invoice iv = new Invoice();
		IShoppingCart isc = findShoppingCartById(id);

		if (isc != null) {
			pt = provider.pay(isc.getTotalPriceOfElements());
			records.add(iv);
			for (IShoppingCart a : shoppingCarts) {
				iv.setInvoiceProducts(a.currentElements());
			}
			iv.addPaymentTransaction(pt);
			isc.currentElements().clear();

		}

		if (pt != null) {

			return iv;
		}
		return iv;

	}

	@Override
	public void registerCashRegisterUI(ICashRegisterUI ui) {
		// TODO Auto-generated method stub
		uis.add(ui);
	}

	@Override
	public IShoppingCartElement selectProduct(String product) {
		if (products != null) {
			for (ITreeNode<IProduct> p : products.searchByFilter(new ProductNameFilter(), product)) {
				if (p.nodeValue().getName().equals(product)) {
					return (IShoppingCartElement) p.nodeValue();
				}

			}
		}
		return null;
	}

	@Override
	public IShoppingCartElement selectProduct(Product product) {
		// TODO Auto-generated method stub
		if (products != null) {
			for (ITreeNode<IProduct> p : products.searchByFilter(new TextSearchIgnoreCaseFilter(), product)) {
				if (p.equals(product)) {
					return (IShoppingCartElement) p.nodeValue();
				}

			}
		}
		return null;
	}

	@Override
	public void unregisterCashRegisterUI(ICashRegisterUI ui) {
		// TODO Auto-generated method stub
		uis.remove(ui);
	}

	@Override
	public String toString() {
		return "CashRegister [id=" + id + "]";
	}

}
