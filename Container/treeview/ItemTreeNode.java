/* 1125266
 * Salih Erbalta
 */
package treeview;
import java.util.Collection;

public class ItemTreeNode<TREETYPE> extends GenericTreeNode<TREETYPE> {

	public ItemTreeNode(TREETYPE item) { 
		super(item);

		
	}

	public Collection<ITreeNode<TREETYPE>> getChildren() {  
		return null;
	}
	
	public <T> boolean checkItem(T item) { 
		
		boolean i = false;
		
		if(this.equals(item) || this.valueProperty().equals(item))
			i=true;



		return i;

	}
}
