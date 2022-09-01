/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree.node;

public class CategoryTreeNode<NODETYPE, CATEGORY> extends GenericTreeNode<NODETYPE> {
	
	


	private CATEGORY category;
	
	public CategoryTreeNode(CATEGORY category) {
		super(category.toString(), null);
		this.category = category;
	}
	

	
	
	public CATEGORY getCategory(){
		return this.category;
	}

	public NODETYPE nodeValue(){
		return null;
	}
	
	public String getLabel()
	{
		return this.category.toString();
	}
	
	public CategoryTreeNode<NODETYPE,CATEGORY> deepCopy(){
		CategoryTreeNode<NODETYPE, CATEGORY> ct = new CategoryTreeNode<NODETYPE, CATEGORY>(this.category);
		
		for(ITreeNode<NODETYPE> copy : this.getChildren()){
			ct.getChildren().add(copy);
		}
		return ct;
	}

}
