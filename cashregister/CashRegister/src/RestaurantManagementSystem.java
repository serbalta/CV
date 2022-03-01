import java.util.Collection;
import java.util.Vector;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import cashregister.CashRegister;
import cashregister.CashRegisterFactory;
import cashregister.ICashRegister;
import cashregister.IObserver;
import cashregister.IShoppingCart;
import cashregister.ui.CashRegisterConsoleUI;
import cashregister.ui.CashRegisterGUI;
import domain.product.IProduct;
import domain.product.JointProduct;
import domain.product.Product;
import domain.product.ProductCategory;
import domain.product.SimpleProduct;
import managementserver.IManagementServer;
import managementserver.ISubjectManagementServer;
import managementtools.ManagementServerViewer;
import menagementserver.ManagementServer;
import tree.GenericTree;
import warehouse.IListener;
import warehouse.IWarehouse;
import warehouse.Warehouse;
import warehouse.ui.WarehouseManager;

public class RestaurantManagementSystem {
	
	private Collection<Warehouse> warehauselist;
	private Collection<IProduct> productList;
	private Collection<ManagementServer> mservers;
	private Collection<IShoppingCart> shopingcarts;

	public static Collection<RestaurantManagementSystem> appList = new Vector<RestaurantManagementSystem>();
	
	public RestaurantManagementSystem(){
		this.productList = new Vector<IProduct>();
		this.warehauselist = new Vector<Warehouse>();
		this.mservers = new Vector<ManagementServer>();
		this.shopingcarts = new Vector<IShoppingCart>();

	}

	public static void main(String[] args) {
		RestaurantManagementSystem a = new RestaurantManagementSystem();
		
//		// Create ManagementServer and Warehouse
		IManagementServer mngServer = ManagementServer.GET_INSTANCE();
		IWarehouse warehouse = Warehouse.GET_INSTANCE();

		// TODO: register mngServer as listener at the warehouse
		
		new WarehouseManager(warehouse);
		new ManagementServerViewer(mngServer);
		((Warehouse)warehouse).registerListener((IListener<IProduct>) mngServer);
		
		// TODO: add Products to warehouse
		SimpleProduct cola = new SimpleProduct("Cola", 1.5f);
		SimpleProduct pizza = new SimpleProduct("Pizza", 5.9f);
		SimpleProduct redbull = new SimpleProduct("Redbull", 3.5f);
		SimpleProduct doner = new SimpleProduct("Doner", 3.9f);
		SimpleProduct minwasser = new SimpleProduct("Mineralwasser", 1f);
		JointProduct pizzacola = new JointProduct("Pizza&Cola Menue" , 10f);
		JointProduct donerredbull = new JointProduct("Doner&reddbull Menue", 15f);
		JointProduct pizzaredbull = new JointProduct("Pizza&Redbull Menue" , 15f);
		JointProduct donercola = new JointProduct("Doner&Cola Menue", 10f);
		JointProduct doublemenue = new JointProduct("Doner+ Pizza + 2 Cola Menue", 20f);

		
		cola.setCategory(ProductCategory.BEVERAGE);
		pizza.setCategory(ProductCategory.FOOD);
		redbull.setCategory(ProductCategory.BEVERAGE);
		doner.setCategory(ProductCategory.FOOD);
		minwasser.setCategory(ProductCategory.BEVERAGE);
		
	
		pizzacola.addProduct(pizza);
		pizzacola.addProduct(cola);
		donerredbull.addProduct(doner);
		donerredbull.addProduct(redbull);
		pizzaredbull.addProduct(pizza);
		pizzaredbull.addProduct(redbull);
		donercola.addProduct(doner);
		donercola.addProduct(cola);
		doublemenue.addProduct(donercola);
		doublemenue.addProduct(pizzacola);

		a.productList.add(doublemenue);
		a.productList.add(donercola);
		a.productList.add(pizzaredbull);
		a.productList.add(donerredbull);
		a.productList.add(minwasser);
		a.productList.add(doner);
		a.productList.add(redbull);
		a.productList.add(pizzacola);
		a.productList.add(pizza);
		a.productList.add(cola);
		
		warehouse.addProducts(a.productList);
		// TODO: create CashRegister and register it as an observer at the mngServer
		ICashRegister cash1 = CashRegisterFactory.createCashRegister();
		((ManagementServer)mngServer).register((IObserver) cash1);
		((ManagementServer)mngServer).addCashRegister(cash1);
		((CashRegister)cash1).activateNotifications((ISubjectManagementServer) mngServer);
	
		// TODO: Create GUI for CashRegister

	
		CashRegisterGUI cashgui  = new CashRegisterGUI(cash1);
		
		// TODO: register CashRegisterGUI as an UI at the previously created cashRegister
		
		cash1.registerCashRegisterUI(cashgui);
		
		a.mservers.add((ManagementServer)mngServer);
		a.warehauselist.add((Warehouse)warehouse);
		
		

	
	}
}
