/* 1125266
 * Salih Erbalta
 */

package treeview;

	public interface ITree<TREETYPE> 
	{

	public void setRoot(ITreeNode<TREETYPE> root);
	
	public ITreeNode<TREETYPE> getRoot();
	
	public <T> ITreeNode<TREETYPE> findElement(T item);
		
} 
