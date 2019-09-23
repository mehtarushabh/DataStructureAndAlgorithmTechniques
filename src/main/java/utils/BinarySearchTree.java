package utils;

/*
 * @author: Rushabh Mehta
 * */

public class BinarySearchTree {
	private int nodeData;
	private BinarySearchTree leftChild;
	private BinarySearchTree rightChild;

	public BinarySearchTree(int nodeData) {
		this.nodeData = nodeData;
		this.leftChild = null;
		this.rightChild = null;
	}


	public void insertNode(int nodeValue) {
		if (nodeValue == nodeData)
			return;

		if (nodeValue < nodeData) {
			if (leftChild == null)
				leftChild = new BinarySearchTree(nodeValue);
			else
				leftChild.insertNode(nodeValue);
		} else {
			if (rightChild == null)
				rightChild = new BinarySearchTree(nodeValue);
			else
				rightChild.insertNode(nodeValue);
		}
	}

	public int getMinimunVale() {
		if (leftChild == null)
			return nodeData;
		else
			return leftChild.getMinimunVale();
	}

	public int getMaximumvalue() {
		if (rightChild == null)
			return nodeData;
		else
			return rightChild.getMaximumvalue();
	}

	public BinarySearchTree getNodeFromValue(int value) {
		if (value == nodeData)
			return this;

		if (value < nodeData && leftChild != null)
			return leftChild.getNodeFromValue(value);
		else if (value > nodeData && rightChild != null)
			return rightChild.getNodeFromValue(value);
		else
			return null;
	}

	public void delete(int value) {
		deleteNode(this, value);
	}

	public void traverseInOrder() {
		if (leftChild != null)
			leftChild.traverseInOrder();
		System.out.print(nodeData + ", ");
		if (rightChild != null)
			rightChild.traverseInOrder();
	}

	public void traversePreOrder() {
		System.out.print(nodeData + ", ");
		if (leftChild != null)
			leftChild.traversePreOrder();
		if (rightChild != null)
			rightChild.traversePreOrder();
	}

	public void traversePostOrder() {
		if (leftChild != null)
			leftChild.traversePostOrder();
		if (rightChild != null)
			rightChild.traversePostOrder();
		System.out.print(nodeData + ", ");
	}

	private BinarySearchTree deleteNode(BinarySearchTree subTreeRoot, int value) {
		if (subTreeRoot == null)
			return subTreeRoot;

		if (value < subTreeRoot.nodeData)
			subTreeRoot.leftChild = deleteNode(subTreeRoot.leftChild, value);
		else if (value > subTreeRoot.nodeData)
			subTreeRoot.rightChild = deleteNode(subTreeRoot.rightChild, value);
		else {
			if (subTreeRoot.leftChild == null)
				return subTreeRoot.rightChild;
			else if (subTreeRoot.rightChild == null)
				return subTreeRoot.leftChild;
			nodeData = rightChild.getMinimunVale();
			rightChild = deleteNode(rightChild, nodeData);
		}
		return subTreeRoot;
	}
}