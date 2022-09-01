/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree.node;

import domain.product.IProduct;
import domain.product.JointProduct;
import domain.product.Product;


public class ProductTreeNode extends GenericTreeNode<IProduct>{
	

	public ProductTreeNode(String label, IProduct value) {

		super(label, value);
		// TODO Auto-generated constructor stub
		
		
			initialize(value);
		
		
	}
	
	public ProductTreeNode(IProduct value){
		super(value.getName(), value);
		
		
			initialize(value);
		
	}
	
	
	private void initialize(IProduct p){
			
		if(p instanceof JointProduct){
				for(Product jp :  ((JointProduct) p).getProducts())
						{
					
						
					this.getChildren().add(new ProductTreeNode(jp.getName(),(IProduct)jp));
					
					
				}
				
		}
		
		
	}
	
	public ProductTreeNode deepCopy(){
		ProductTreeNode cptn = new ProductTreeNode(this.getLabel(),this.nodeValue());
			
		for(ITreeNode<?> cpy : this.getChildren()){
			cptn.getChildren().add((ITreeNode<IProduct>) cpy);
		}
		
		return cptn;
	}
}
