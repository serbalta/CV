/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree;

import java.util.Collection;

import domain.copy.IDeepCopy;
import tree.node.ITreeNode;
import util.searchable.ISearchFilter;
import util.searchable.ISearchableByFilter;

public class GenericTree<TREETYPE> implements IDeepCopy, ISearchableByFilter<ITreeNode<TREETYPE>>, ITree<TREETYPE> {

	private ITreeNode<TREETYPE> root;

	public GenericTree() {
		this.root = null;	
	}

	public GenericTree(ITreeNode<TREETYPE> root) {
		this.root = root;
	}

	public void setRoot(ITreeNode<TREETYPE> root) {
		this.root =  root;

	}

	@Override
	public ITreeNode<TREETYPE> getRoot() {

		return this.root;
	}

	@Override
	public ITreeNode<TREETYPE> findNodeByValue(TREETYPE searchValue) {
		
		return root.findNodeByValue(searchValue);
	}

	@Override
	public ITreeNode<TREETYPE> findNodeByNode(ITreeNode<TREETYPE> searchNode) {
		// TODO Auto-generated method stub
		
		
		return root.findNodeByNode(searchNode);
	}

	@Override
	public String generateConsoleView(String spacer) {
		// TODO Auto-generated method stub
		String s = "";
		s = root.generateConsoleView(spacer, "");
		return s;
	}

	@Override
	public ITree<TREETYPE> deepCopy() {
		// TODO Auto-generated method stub
		return  (ITree<TREETYPE>) root.deepCopy();
	}

	@Override
	public Collection<ITreeNode<TREETYPE>> searchByFilter(ISearchFilter filter, Object compareObject) {
		// TODO Auto-generated method stub
		return root.searchByFilter(filter, compareObject);
	}

}
