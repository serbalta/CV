/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */

import java.util.Collection;
import container.Container;
import domain.product.IProduct;
import domain.product.JointProduct;
import domain.product.SimpleProduct;
import tree.ProductTree;
import tree.node.CategoryTreeNode;
import tree.node.ProductCategoryTreeNode;
import tree.node.ProductTreeNode;

import util.ProductCategory;

public class Application {

	private Collection<IProduct> productlist;

	public Application() {

		productlist = new Container<IProduct>();

	}

	public static void main(String[] args) {

		Application app = new Application();
		app.generateConsolView();

	}

	public void generateConsolView() {

		SimpleProduct sp0 = new SimpleProduct("Cola", (float) 1.80);
		SimpleProduct sp1 = new SimpleProduct("Bier", (float) 2.80);
		SimpleProduct sp2 = new SimpleProduct("Fanta", (float) 1.80);
		SimpleProduct sp3 = new SimpleProduct("Redbull", (float) 3.00);
		SimpleProduct sp4 = new SimpleProduct("LinzenSuppe", (float) 3.00);
		SimpleProduct sp5 = new SimpleProduct("TomatenSuppe", (float) 3.50);
		SimpleProduct sp6 = new SimpleProduct("Pizza Margerita", (float) 7.00);
		SimpleProduct sp7 = new SimpleProduct("Pizza Salami", (float) 7.30);
		SimpleProduct sp8 = new SimpleProduct("Doener", (float) 3.00);
		SimpleProduct sp9 = new SimpleProduct("Tiramisu", (float) 5.50);
		SimpleProduct sp10 = new SimpleProduct("BananenSplit", (float) 6.00);

		JointProduct jp1 = new JointProduct("Menue1", sp0.getPrice()+sp7.getPrice()+sp9.getPrice());
		productlist.add(jp1);
	
		JointProduct jp2 = new JointProduct("Menue2", 15f);
		productlist.add(jp2);

		JointProduct jp3 = new JointProduct("Menue3", 10f);
		productlist.add(jp3);

		JointProduct jp4 = new JointProduct("Menue4", 20f);
		productlist.add(jp4);

		
		jp1.addProduct(sp0);

		jp1.addProduct(sp1);
		jp1.addProduct(sp2);
		jp1.addProduct(sp3);
		jp2.addProduct(sp4);
		jp2.addProduct(sp5);
		
		jp3.addProduct(sp6);
		jp3.addProduct(sp7);
		jp3.addProduct(sp8);
		jp2.addProduct(sp10);

		jp4.addProduct(jp1);
		jp4.addProduct(jp2);

		
		ProductTreeNode ptn = new ProductTreeNode(jp1);
		ProductTreeNode ptn1 = new ProductTreeNode(jp2);
		ProductTreeNode ptn2 = new ProductTreeNode(jp4);



		ProductCategoryTreeNode<IProduct> pctn = new ProductCategoryTreeNode<IProduct>(ProductCategory.BEVERAGE);
		ProductCategoryTreeNode<IProduct> pctn1 = new ProductCategoryTreeNode<IProduct>(ProductCategory.DEFAULT);
		ProductCategoryTreeNode<IProduct> pctn2 = new ProductCategoryTreeNode<IProduct>(ProductCategory.FOOD);
		CategoryTreeNode<IProduct, String> categoryTr = new CategoryTreeNode<IProduct, String>("1. CATEGORY");
		CategoryTreeNode<IProduct, String> categoryTr1 = new CategoryTreeNode<IProduct, String>("2. CATEGORY");
		CategoryTreeNode<IProduct, String> categoryTr2 = new CategoryTreeNode<IProduct, String>("3. CATEGORY");
		pctn.getChildren().add(ptn);
		pctn1.getChildren().add(ptn1);
		pctn2.getChildren().add(ptn2);
		ProductTree protree = new ProductTree(categoryTr);
		ProductTree protree1 = new ProductTree(categoryTr1);
		ProductTree protree2 = new ProductTree(categoryTr2);

		protree.getRoot().getChildren().add(pctn);
		System.out.println(protree.generateConsoleView("    "));
		
		protree1.getRoot().getChildren().add(pctn);
		protree1.getRoot().getChildren().add(pctn1);
		System.out.println(protree1.generateConsoleView("    "));
		
		
		protree2.getRoot().getChildren().add(pctn);
		protree2.getRoot().getChildren().add(pctn1);
		protree2.getRoot().getChildren().add(pctn2);
		System.out.println(protree2.generateConsoleView("    "));
		
	}
}
