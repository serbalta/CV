/* 1125266
 * Salih Erbalta
 */

package treeview;

import java.util.Collection;

public interface ITreeNode<TREETYPE> {
 
	public TREETYPE valueProperty();
	public boolean isLeaf();
	public Collection<ITreeNode<TREETYPE>> getChildren();
	public <T> ITreeNode<TREETYPE> findItem(T item);
	public <T> boolean checkItem(T item);
	public String generateConsoleView(String spacer,String preamble);
	
}
