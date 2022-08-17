/* 1125266
 * Salih Erbalta
 */


package treeview;

public class GenericTreeView<TREETYPE> implements ITree<TREETYPE> {
		
	private ITreeNode<TREETYPE> root;
	
	
	public GenericTreeView(){
		
	}
	
	public GenericTreeView(ITreeNode<TREETYPE> root){
		this.root = root;
		
	}
	public void setRoot(ITreeNode<TREETYPE> root) {
		this.root = root;
		
	}

	
	public ITreeNode<TREETYPE> getRoot() {
		
		return root;
	}

	
	public <T> ITreeNode<TREETYPE> findElement(T item) {
		
		
		return root.findItem(item);
	}

	public String generateConsoleView(String spacer) {
		return root.generateConsoleView(spacer, spacer);
	}
}
