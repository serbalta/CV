package menagementserver;

import domain.product.*;
import tree.node.*;

import util.searchable.ProductCategoryNodeFilter;
import util.searchable.ProductNameFilter;

import java.util.Collection;
import java.util.Vector;


import cashregister.CashRegister;
import cashregister.ICashRegister;
import cashregister.IObserver;
import cashregister.NotRegisteredException;
import container.Container;
import domain.product.IProduct;
import managementserver.IManagementServer;
import managementserver.ISubjectManagementServer;

import tree.GenericTree;
import tree.ITree;
import warehouse.IWarehouseListener;

public class ManagementServer implements IManagementServer, IWarehouseListener, ISubjectManagementServer {

	private Collection<ICashRegister> cashRegisters;
	private Collection<IObserver> observer;
	private ITree<IProduct> productAssortment;
	private static ManagementServer INSTANCE = null;

	private ManagementServer() {

		this.initialize();
		this.cashRegisters = new Vector<ICashRegister>();
		this.observer = new Vector<IObserver>();
	}

	private void initialize() {
		this.productAssortment = new GenericTree<IProduct>();
		CategoryTreeNode<IProduct, String> root = new CategoryTreeNode<IProduct, String>("Products");

		for (ProductCategory category : ProductCategory.values()) {
			root.getChildren().add(new ProductCategoryTreeNode<IProduct>(category));
		}
		this.productAssortment.setRoot(root);

	}

	public static IManagementServer GET_INSTANCE() {

		if (ManagementServer.INSTANCE == null) {
			ManagementServer.INSTANCE = new ManagementServer();

		}
		return ManagementServer.INSTANCE;
	}

		
		

	private Collection<ITreeNode<IProduct>> categoryList() {
		Collection<ITreeNode<IProduct>> temp = new Container<>();

		for (ITreeNode<IProduct> p : productAssortment.getRoot().getChildren()) {
			for (ITreeNode<IProduct> p1 : p.getChildren()) {

				temp.add(p1);
			}
		}
		return temp;
	}

	
	
	
	@Override
	public void notifyChange(IProduct object) {
		// TODO Auto-generated method stub
		Collection<ITreeNode<IProduct>> temp1 = this.productAssortment.searchByFilter(new ProductNameFilter(),object);
		
		
		for (ITreeNode<IProduct> p : categoryList()) {
			// JOptionPane.showMessageDialog(null, "1 ");
			if (p.nodeValue().equals(object)) {
			
				this.productAssortment.removeNode(p);
				productAdded(object);
			} 
	
		}
		for (ITreeNode<IProduct> p : temp1) {
			if (object.getPrice() != p.nodeValue().getPrice()) {
				p.nodeValue().setPrice(object.getPrice());
			}
			
				if (object instanceof JointProduct && p.nodeValue() instanceof JointProduct) {
					for (IProduct p1 : ((JointProduct) object).getProducts()) {
							((JointProduct) p.nodeValue()).addProduct((Product) p1);
							p.getChildren().add(new ProductTreeNode(object));
					}
				}
				

		}

	}

	@Override
	public void productRemoved(IProduct product) {
		// TODO Auto-generated method stub
		productAssortment.removeNode(product);
		System.out.println(product + " removed!");
		System.out.println("New Tree:");
		System.out.println(this.productAssortment.generateConsoleView(" "));

	}

	@Override
	public void addCashRegister(ICashRegister cashRegister) {
		// TODO Auto-generated method stub
		if (cashRegister instanceof IObserver) {
			this.observer.add((IObserver) cashRegister);
			this.cashRegisters.add(cashRegister);
		} else {
			cashRegisters.add(cashRegister);
		}
	}

	@Override
	public void propagateProducts() {
		// TODO Auto-generated method stub
		if (observer != null) {
			for (IObserver obs : observer) {
				obs.notifyChange(INSTANCE);
			}
		}
	}

	@Override
	public ITree<IProduct> retrieveProductSortiment() {
		// TODO Auto-generated method stub
		return productAssortment.deepCopy();
	}

	@Override
	public ICashRegister retrieveRegisteredCashRegister(Long cashRegisterId) throws NotRegisteredException {
		// TODO Auto-generated method stub
		if (cashRegisters != null) {
			for (ICashRegister a : cashRegisters) {
				if (a.getID() == cashRegisterId) {
					return a;
				}
			}
		}
		throw new NotRegisteredException("Wrong Id");

	}

	@Override
	public Collection<ICashRegister> retrieveRegisteredCashRegisters() {
		// TODO Auto-generated method stub
		return this.cashRegisters;
	}

	@Override
	public void unregisterCashRegister(ICashRegister cashRegister) throws NotRegisteredException {
		// TODO Auto-generated method stub
		if (cashRegisters != null) {
			for (ICashRegister a : cashRegisters) {
				if (a.equals(cashRegister)) {
					if (a instanceof IObserver) {
						observer.remove((IObserver) a);
						cashRegisters.remove(a);
						((CashRegister)cashRegister).deactivateNotifications(INSTANCE);
					} else
						cashRegisters.remove(a);
					((CashRegister)cashRegister).deactivateNotifications(INSTANCE);

					System.out.println();
				}
			}
		}
	}

	@Override
	public ITree<IProduct> getChanges() {
		// TODO Auto-generated method stub
		return this.productAssortment.deepCopy();
	}

	@Override
	public boolean register(IObserver obs) {
		// TODO Auto-generated method stub
		boolean i = false;
		if (obs != null && this.observer.contains(obs) == false) {
			if (observer.add(obs) == true) {
				obs.activateNotifications(INSTANCE);
				obs.notifyChange(INSTANCE);
				i = true;
			}
		} else {
			obs.activateNotifications(INSTANCE);
			obs.notifyChange(INSTANCE);
			i = true;
			return i;
		}
		return i;

	}

	@Override
	public boolean unregister(IObserver obs) {
		// TODO Auto-generated method stub
		boolean i = false;

		if (obs != null && this.observer.contains(obs) == true) {
			if (observer.remove(obs) == true) {
				obs.deactivateNotifications(INSTANCE);
				i = true;
			}
		}

		return i;
	}

	@Override
	public void productAdded(IProduct product) {
		// TODO Auto-generated method stub
		Collection<ITreeNode<IProduct>> temp = this.productAssortment.searchByFilter(new ProductCategoryNodeFilter(),
				product.getCategory());

		if (temp != null) {
			temp.iterator().next().getChildren().add(new ProductTreeNode(product));
		} else {

			temp = this.productAssortment.searchByFilter(new ProductCategoryNodeFilter(), ProductCategory.DEFAULT);
			temp.iterator().next().getChildren().add(new ProductTreeNode(product));

		}

	}

}
