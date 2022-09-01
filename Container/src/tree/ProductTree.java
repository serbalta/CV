/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree;

import domain.product.IProduct;
import tree.node.ITreeNode;
import tree.node.ProductTreeNode;

public class ProductTree extends GenericTree<IProduct> {

	
	public ProductTree(ITreeNode<IProduct> root)
	{
		setRoot(root);
		
	}
	
	public ProductTree(IProduct product){
		setRoot(new ProductTreeNode(product.getName(), product));
	}
	public ProductTree(){
		setRoot(null);
	}
}
