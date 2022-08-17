/* 1125266
 * Salih Erbalta
 */
package treeview;

public class GroupTreeNode<TREETYPE> extends GenericTreeNode<TREETYPE> {


	private String groupName = null; 
	
	public GroupTreeNode(String groupName) {
		super(null); 
		this.groupName = groupName;
	}

	public TREETYPE valueProperty() { 
		return null;

	}
	public boolean isLeaf(){
		return false;
		
	}
	
	
	
	public <T> boolean checkItem(T item) 
	{
	 if(this.equals(item) || (groupName.equals(item))) 
		 return true;
	 else 
		 return false;
	}
	
	public String toString()
	{
	 return "Group name = " + groupName;
	}
	
	

}
