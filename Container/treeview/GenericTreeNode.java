/* 1125266
 * Salih Erbalta
 */
package treeview;

import java.util.*;


public class GenericTreeNode<TREETYPE> implements ITreeNode<TREETYPE> {


	private TREETYPE property = null; 
	private Collection <ITreeNode<TREETYPE>> children; 

	public GenericTreeNode(TREETYPE item) { 
		property = item; 
		children = new Vector<ITreeNode<TREETYPE>>();

	}
	public GenericTreeNode(){

	}

	public Collection<ITreeNode<TREETYPE>> getChildren() {
		return children; 
	}

	public boolean isLeaf() { 
		if (children.isEmpty()) 
			return true;
		else
			return false;
	}

	public TREETYPE valueProperty() { 

		return property;
	}

	public <T> ITreeNode<TREETYPE> findItem(T item) { 
		if(getChildren()!= null) { 
			if (checkItem(item)) { 
				return this; 
			}
			else { 
				for(ITreeNode<TREETYPE> b : children){
					if(b.findItem(item)!=null){
					return b;}
				}
				return null;


			}
		}
		else { 
			if(checkItem(item)){
				return this;
			}
			else{
				return null;
			}



		}




	}

	public <T> boolean checkItem(T item) {  


		boolean i = false;
		
		if (this.equals(item) || property.equals(item)) {
			i = true;  
		}
		return i; 
	}
	public String generateConsoleView(String spacer, String preamle) {
		String s = " ";
		preamle = this.toString();
		int agroup = 0;
		int aitem = 0;

		s += (preamle + "\n" + "  ");

		if (this.getChildren() != null) {
			for (ITreeNode<TREETYPE> child : children) {
				if (child instanceof GroupTreeNode) {
					agroup++;
					s = s.concat(spacer
							+ agroup
							+ ". Group: "
							+ ((GroupTreeNode<TREETYPE>) child).generateConsoleView(
							spacer, preamle));
				} else if (child instanceof ItemTreeNode) {
					aitem++;
					s = s.concat("  "
							+ spacer
							+ aitem
							+ ". Element: "
							+ ((ItemTreeNode<TREETYPE>) child).generateConsoleView(
							spacer, preamle));
				}
			}

		}

		return s;
	}

	public TREETYPE getProperty() {
		return property;
	}

	public void setProperty(TREETYPE property) {
		this.property = property;
	}

	public String toString(){
		return String.valueOf(valueProperty());
	}
	}

