/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package tree.node;

import java.util.Collection;

import container.Container;

import util.searchable.ISearchFilter;

public class GenericTreeNode<NODETYPE> implements ITreeNode<NODETYPE> {

	private Collection<ITreeNode<NODETYPE>> children;
	private String label;
	private NODETYPE nodeValue;

	public GenericTreeNode(String label, NODETYPE value) {

		this.children = new Container<ITreeNode<NODETYPE>>();
		this.label = label;
		this.nodeValue = value;
	}

	public void setNodeValue(NODETYPE nodeValue) {
		this.nodeValue = nodeValue;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public Collection<ITreeNode<NODETYPE>> searchByFilter(ISearchFilter filter, Object compareObject) {
		// TODO Auto-generated method stub
		Collection<ITreeNode<NODETYPE>> temp = new Container<ITreeNode<NODETYPE>>();

		if (filter.searchFilterFunction(this, compareObject)
				|| filter.searchFilterFunction(this.nodeValue(), ((ITreeNode<NODETYPE>) compareObject).nodeValue())) {
			temp.add(this);

		}

		for (ITreeNode<NODETYPE> Node : this.getChildren()) {
			temp.addAll(Node.searchByFilter(filter, compareObject));
		}

		return temp;

	}

	@Override
	public NODETYPE nodeValue() {
		// TODO Auto-generated method stub
		return this.nodeValue;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		if (children.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Collection<ITreeNode<NODETYPE>> getChildren() {
		// TODO Auto-generated method stub
		return this.children;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return this.label;
	}

	@Override
	public ITreeNode<NODETYPE> findNodeByValue(NODETYPE searchValue) {
		// TODO Auto-generated method stub
		if (this.children != null) {
			if (checkNodeByValue(searchValue)) {
				return this;
			} else {
				for (ITreeNode<NODETYPE> c : children)
					if (c.findNodeByValue(searchValue) != null) {
						return c;
					}
			}

			return null;
		} else {
			if (checkNodeByValue(searchValue)) {
				return this;
			} else {
				return null;
			}

		}
	}

	@Override
	public ITreeNode<NODETYPE> findNodeByNode(ITreeNode<NODETYPE> searchNode) {
		if (this.children != null) {
			if (this.equals(searchNode)) {
				return this;
			} else {
				for (ITreeNode<NODETYPE> c : children)
					if (c.findNodeByNode(searchNode) != null) {
						return c;
					}
			}

			return null;
		} else {
			if (this.equals(searchNode)) {
				return this;
			} else {
				return null;
			}

		}
	}

	@Override
	public boolean checkNodeByValue(NODETYPE value) {
		// TODO Auto-generated method stub
		boolean i = false;

		if (this.nodeValue().equals(value) || nodeValue.equals(value)) {
			i = true;
		}
		return i;
	}

	@Override
	public String generateConsoleView(String spacer, String preamble) {
		String s = " ";
		preamble = preamble + spacer;


		s += preamble + this.toString() + "\n";
		for (ITreeNode<NODETYPE> childNodes : children) {

			s += childNodes.generateConsoleView(spacer, (preamble));
		}

		return s;
	}

	public String toString() {

		if (isLeaf())
			return "-" + getClass().getSimpleName().toString() + ": " + this.getLabel();

		else
			return "+" + getClass().getSimpleName().toString() + ": " + this.getLabel();

	}

	@Override
	public GenericTreeNode<NODETYPE> deepCopy() {
		// TODO Auto-generated method stub
		GenericTreeNode<NODETYPE> cgtn = new GenericTreeNode<NODETYPE>(this.getLabel(), this.nodeValue());
		for (ITreeNode<NODETYPE> cpy : this.getChildren()) {
			cgtn.getChildren().add(cpy);
		}
		return cgtn;
	}

}
