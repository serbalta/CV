/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree.node;

import domain.copy.IDeepCopy;

public class CopyableTreeNode<NODETYPE extends IDeepCopy> extends GenericTreeNode<NODETYPE> {

	public CopyableTreeNode(String label, NODETYPE value) {
		super(label, value);
		// TODO Auto-generated constructor stub
	}

	
	public CopyableTreeNode<NODETYPE> deepCopy(){
			CopyableTreeNode<NODETYPE> cpy = new CopyableTreeNode<NODETYPE>(this.getLabel(), this.nodeValue());
			
			for (ITreeNode<NODETYPE> copy : this.getChildren()){
				cpy.getChildren().add(copy);
			}
		
		
		
		
		return cpy;
	}
}
