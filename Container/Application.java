/* 1125266
 * Salih Erbalta
 */
import java.util.*;

import domain.product.JointProduct;
import domain.product.Product;
import domain.product.SimpleProduct;
import treeview.*;


public class Application {


	private Collection <GenericTreeView<?>> generictreeviewlist;
	
	
	
	public Application(){


		generictreeviewlist = new Vector <GenericTreeView<?>>();
		
	}
	
	public static void main(String[] args) {

		Application app = new Application();
		app.generateConsoleView();


		Product p1=new Product("pro",123.3F);
		System.out.println(p1);
		
		
	}

	public void generateConsoleView()
	{

		
		Product pp=new Product("name",123.4F);
        JointProduct jopro = new JointProduct("jopro",111.5f);
        JointProduct jopro1 = new JointProduct("jopro1",112.5f);
        JointProduct jopro2 = new JointProduct("jopro2",113.5f);
        JointProduct jopro3 = new JointProduct("jopro3",114.5f);
        SimpleProduct simpro = new SimpleProduct("simpro",111.5f);
		
		
		
		ItemTreeNode<String> itreenode1 = new ItemTreeNode<String>("abc");
		ItemTreeNode<String> itreenode11 = new ItemTreeNode<String>("abcs");
		ItemTreeNode<String> itreenode12 = new ItemTreeNode<String>("abcd");
		ItemTreeNode<String> itreenode2 = new ItemTreeNode<String>("firat");
		ItemTreeNode<String> itreenode3 = new ItemTreeNode<String>("firrrooo");
		ItemTreeNode<Integer> itreenode22 = new ItemTreeNode<Integer>(3);
		ItemTreeNode<Integer> itreenode23 = new ItemTreeNode<Integer>(4);
		ItemTreeNode<String> itreenode4 = new ItemTreeNode<String>("ahmet");
		ItemTreeNode<Product> itreenode5 = new ItemTreeNode<Product>(jopro1);
		ItemTreeNode<Integer> itreenode6 = new ItemTreeNode<Integer>(5);
		ItemTreeNode<Product> itreenode7 = new ItemTreeNode<Product>(jopro);
		

		
		GroupTreeNode<String> grouptreenode1 = new GroupTreeNode<String >("Group1");
		GroupTreeNode<String> grouptreenode2 = new GroupTreeNode<String>("Group2");
		GroupTreeNode<String> grouptreenode3 = new GroupTreeNode<String>("Group3");
		GroupTreeNode<String> grouptreenode4 = new GroupTreeNode<String>("Group4");
		GroupTreeNode<String> grouptreenode5 = new GroupTreeNode<String>("Group5");
		GroupTreeNode<Product> grouptreenode6 = new GroupTreeNode<Product>("Group6");
		GroupTreeNode<String> grouptreenode7 = new GroupTreeNode<String>("Group7");
		GroupTreeNode<String> grouptreenode8 = new GroupTreeNode<String>("Group8");
		
		grouptreenode1.getChildren().add(itreenode1);
		grouptreenode1.getChildren().add(itreenode11);
		grouptreenode2.getChildren().add(itreenode12);
		grouptreenode2.getChildren().add(itreenode2);
		grouptreenode3.getChildren().add(grouptreenode4);
		grouptreenode3.getChildren().add(grouptreenode5);
		grouptreenode4.getChildren().add(itreenode3);
		grouptreenode6.getChildren().add(itreenode7);
		grouptreenode6.getChildren().add(itreenode5);

        


		GenericTreeNode<String> generictreenode1 = new GenericTreeNode<String>("BBB");
		GenericTreeNode<String> generictreenode12 = new GenericTreeNode<String>("ATAT");
		GenericTreeNode<Float> GTN = new GenericTreeNode<>();
		GenericTreeNode<Integer> generictreenode2 = new GenericTreeNode<Integer>(2);
		GenericTreeNode<Integer> generictreenode3 = new GenericTreeNode<Integer>(3);
		GenericTreeNode<Integer> generictreenode4 = new GenericTreeNode<Integer>(4);
		GenericTreeNode<Product> generictreenode5 = new GenericTreeNode<Product>(pp);
		GenericTreeNode<Product> generictreenode6 = new GenericTreeNode<Product>(jopro);
		GenericTreeNode<Product> generictreenode7 = new GenericTreeNode<Product>(simpro);


		
		generictreenode1.getChildren().add(grouptreenode1);
		generictreenode1.getChildren().add(grouptreenode2);
		generictreenode1.getChildren().add(grouptreenode3);
		generictreenode7.getChildren().add(grouptreenode6);
		generictreenode12.getChildren().add(grouptreenode8);


		

		
		GenericTreeView<String> generictreeview1 = new GenericTreeView<String>(generictreenode1);
		GenericTreeView<Product> generictreeview2 = new GenericTreeView<Product>(generictreenode7);
		GenericTreeView<String> generictreeview3 = new GenericTreeView<String>(generictreenode12);
		
		
		generictreeviewlist.add(generictreeview1);
		generictreeviewlist.add(generictreeview2);
		generictreeviewlist.add(generictreeview3);
		
	int i = 0;
		
		for(GenericTreeView<?> generics : generictreeviewlist){
			i++;
		System.out.println(i + ".Tree:");

			System.out.println(generics.generateConsoleView("    "));
			if(generictreeview1.findElement("abc")!= null){

			}
			else
				System.out.println("Könnte nicht finden! ");


		
		
		}
		
	}
}
