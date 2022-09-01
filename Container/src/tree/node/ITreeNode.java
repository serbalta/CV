/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree.node;

import java.util.Collection;

import domain.copy.IDeepCopy;
import util.searchable.ISearchableByFilter;

public interface ITreeNode<NODETYPE> extends IDeepCopy, ISearchableByFilter<ITreeNode<NODETYPE>> {

	public NODETYPE nodeValue();

	public boolean isLeaf();

	public Collection<ITreeNode<NODETYPE>> getChildren();

	public String getLabel();

	public ITreeNode<NODETYPE> findNodeByValue(NODETYPE searchValue);

	public ITreeNode<NODETYPE> findNodeByNode(ITreeNode<NODETYPE> searchNode);

	public boolean checkNodeByValue(NODETYPE value);

	public String generateConsoleView(String spacer, String preamble);

	public ITreeNode<NODETYPE> deepCopy();

}
