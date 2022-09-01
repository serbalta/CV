/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree;

import domain.copy.IDeepCopy;
import tree.node.ITreeNode;
import util.searchable.ISearchableByFilter;

public interface ITree<TREETYPE> extends IDeepCopy, ISearchableByFilter<ITreeNode<TREETYPE>> {

	public void setRoot(ITreeNode<TREETYPE> root);

	public ITreeNode<TREETYPE> getRoot();

	public ITreeNode<TREETYPE> findNodeByValue(TREETYPE searchValue);

	public ITreeNode<TREETYPE> findNodeByNode(ITreeNode<TREETYPE> searchNode);

	public String generateConsoleView(String spacer);

	public ITree<TREETYPE> deepCopy();

}
