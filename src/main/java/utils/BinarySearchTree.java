package utils;

public class BinarySearchTree {
	private int nodeData;
	private BinarySearchTree leftChild;
	private BinarySearchTree rightChild;

	public BinarySearchTree(int nodeData) {
		this.nodeData = nodeData;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getNodeData() {
		return nodeData;
	}

	public void setNodeData(int nodeData) {
		this.nodeData = nodeData;
	}

	public BinarySearchTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinarySearchTree leftChild) {
		this.leftChild = leftChild;
	}

	public BinarySearchTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinarySearchTree rightChild) {
		this.rightChild = rightChild;
	}

	public void insertNode(int nodeValue) {
		if (nodeValue == getNodeData())
			return;

		if (nodeValue < getNodeData()) {
			if (getLeftChild() == null)
				setLeftChild(new BinarySearchTree(nodeValue));
			else
				getLeftChild().insertNode(nodeValue);
		} else {
			if (getRightChild() == null)
				setRightChild(new BinarySearchTree(nodeValue));
			else
				getRightChild().insertNode(nodeValue);
		}
	}

	public int getMinimunVale() {
		if (getLeftChild() == null)
			return getNodeData();
		else
			return getLeftChild().getMinimunVale();
	}

	public int getMaximumvalue() {
		if (getRightChild() == null)
			return getNodeData();
		else
			return getRightChild().getMaximumvalue();
	}

	public BinarySearchTree getNodeFromValue(int value) {
		if (value == getNodeData())
			return this;

		if (value < getNodeData() && getLeftChild() != null)
			return getLeftChild().getNodeFromValue(value);
		else if (value > getNodeData() && getRightChild() != null)
			return getRightChild().getNodeFromValue(value);
		else
			return null;
	}

	public void delete(int value) {
		deleteNode(this, value);
	}

	public void traverseInOrder() {
		if (getLeftChild() != null)
			getLeftChild().traverseInOrder();
		System.out.print(getNodeData() + ", ");
		if (getRightChild() != null)
			getRightChild().traverseInOrder();
	}

	public void traversePreOrder() {
		System.out.print(getNodeData() + ", ");
		if (getLeftChild() != null)
			getLeftChild().traversePreOrder();
		if (getRightChild() != null)
			getRightChild().traversePreOrder();
	}

	public void traversePostOrder() {
		if (getLeftChild() != null)
			getLeftChild().traversePostOrder();
		if (getRightChild() != null)
			getRightChild().traversePostOrder();
		System.out.print(getNodeData() + ", ");
	}

	private BinarySearchTree deleteNode(BinarySearchTree subTreeRoot, int value) {
		if (subTreeRoot == null)
			return subTreeRoot;

		if (value < subTreeRoot.getNodeData())
			subTreeRoot.setLeftChild(deleteNode(subTreeRoot.getLeftChild(), value));
		else if (value > subTreeRoot.getNodeData())
			subTreeRoot.setRightChild(deleteNode(subTreeRoot.getRightChild(), value));
		else {
			if (subTreeRoot.getLeftChild() == null)
				return subTreeRoot.getRightChild();
			else if (subTreeRoot.getRightChild() == null)
				return subTreeRoot.getLeftChild();
			setNodeData(getRightChild().getMinimunVale());
			setRightChild(deleteNode(getRightChild(), getNodeData()));
		}
		return subTreeRoot;
	}

}