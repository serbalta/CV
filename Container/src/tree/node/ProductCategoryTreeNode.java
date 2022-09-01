/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree.node;

import util.ProductCategory;

public class ProductCategoryTreeNode<NODETYPE> extends CategoryTreeNode<NODETYPE, ProductCategory> {



	public ProductCategoryTreeNode(ProductCategory category) {
		super(category);
		// TODO Auto-generated constructor stub
	}

	public String getLabel(){
		return super.getLabel();
	}

}
