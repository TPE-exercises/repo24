package de.hsMannheim.tpe.ss17.gruppe24.uebung5.aufgabe2;

import static gdi.MakeItSimple.*;

public class BTree2<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> root;
	private int order;

	// Helper field for getAll()
	private int dataIndex;

	
	
	
	public BTree2(int order) {
		if (order < 1)
			this.order = 1;
		else
			this.order = order;
	}

	/**
	 * return an object of a BTreeIterator
	 */
	@Override
	public BTreeIterator<T> iterator(){
		return new BTreeIterator<T>(this.getAll());
	}
	
	
	private void split(Node<T> currentNode) {

		// Divide values into currentNode and newNode
		Node newNode = new Node<T>(this.order, currentNode.parent, currentNode.isLeaf);
		Comparable middleValue = currentNode.data[this.order];

		for (int i = 0; i < this.order; i++) {
			newNode.data[i] = currentNode.data[i + this.order + 1];
		}
		newNode.numberOfData = this.order;

		if (!currentNode.isLeaf) {
			for (int i = 0; i < newNode.children.length / 2; i++) {
				newNode.children[i] = currentNode.children[(2 * order + 2) / 2 + i];
				newNode.children[i].parent = newNode;
			}

			for (int i = currentNode.children.length / 2 ; i < currentNode.children.length; i++) {
				currentNode.children[i] = null;
			}
		}

		// Only the values with index < this.order remain in the left node
		currentNode.numberOfData = this.order;

		// create new Root if needed
		if (currentNode.parent == null) {

			Node newRoot = new Node(this.order, null);
			currentNode.parent = newRoot;
			newNode.parent = newRoot;
			newRoot.data[0] = middleValue;
			newRoot.numberOfData = 1;
			newRoot.children[0] = currentNode;
			newRoot.children[1] = newNode;
			newRoot.isLeaf = false;
			this.root = newRoot;
		}

		// a parent already exists
		else if (currentNode.parent.numberOfData < 2 * order + 1) {
			insertIntoNode(currentNode.parent, middleValue);
			int positionOfCurrentNode = 0;
			while (currentNode.parent.children[positionOfCurrentNode] != currentNode) {
				positionOfCurrentNode++;
			}

			int currentPosition = currentNode.parent.children.length - 2;

			while (currentPosition > positionOfCurrentNode) {
				currentNode.parent.children[currentPosition + 1] = currentNode.parent.children[currentPosition];
				currentPosition--;
			}
			currentNode.parent.children[positionOfCurrentNode + 1] = newNode;
			newNode.parent = currentNode.parent;

			// parent is full
			if (currentNode.parent.numberOfData == 2 * order + 1) {
				split(currentNode.parent);
			}
		}

	}


	public boolean insert(Comparable o) {

		if (contains(o)) {
			return false;
		}

		if (isEmpty()) {
			root = new Node(this.order, null);
		}

		Node currentNode = root;

		if (!currentNode.isLeaf) {

			currentNode = goDeeper(currentNode, o);
		}

		if (currentNode.isLeaf && currentNode.numberOfData < 2 * order + 1) {
			insertIntoNode(currentNode, o);

			if (currentNode.numberOfData == 2 * order + 1) {
				split(currentNode);
			}

		}

		return true;
	}

	/**
	 * finds the appropriate node to insert a new reference value
	 * 
	 * @param currentNode
	 *            start with root
	 * @param valueToInsert
	 *            the Comparable object to insert
	 * @return
	 */
	private Node goDeeper(Node currentNode, Comparable valueToInsert) {

		if (!currentNode.isLeaf) {
			int i = 0;
			while (i + 1 < currentNode.numberOfData && currentNode.data[i].compareTo(valueToInsert) < 0) {
				i++;
			}
			if (currentNode.data[i].compareTo(valueToInsert) > 0) {
				currentNode = currentNode.children[i];
			} else {
				currentNode = currentNode.children[i + 1];
			}

			return goDeeper(currentNode, valueToInsert);
		}

		return currentNode;
	}

	/**
	 * When the correct node is already found the new Comparable reference is added
	 * 
	 * @param node
	 * @param valueToInsert
	 */
	private void insertIntoNode(Node node, Comparable valueToInsert) {
		int i = node.numberOfData;
		for (i = node.numberOfData; i >= 1 && node.data[i - 1].compareTo(valueToInsert) > 0; i--) {
			node.data[i] = node.data[i - 1];
		}
		node.data[i] = valueToInsert;
		node.numberOfData++;
	}


	public boolean insert(String filename) {
		if (!isFilePresent(filename))
			return false;
		Object file = openInputFile(filename);

		while (!isEndOfInputFile(file)) {
			insert(readInt(file));
		}

		closeInputFile(file);
		return true;
	}


	public boolean contains(Comparable o) {

		if (isEmpty())
			return false;
		return contains(this.root, o);
	}

	private boolean contains(Node currentNode, Comparable valueToSearch) {
		int i = 0;
		if (currentNode.isLeaf) {
			while (i < currentNode.numberOfData) {
				if (currentNode.data[i].compareTo(valueToSearch) == 0)
					return true;
				i++;
			}
		}

		else {

			while (i + 1 < currentNode.numberOfData && currentNode.data[i].compareTo(valueToSearch) < 0) {
				i++;
			}
			if (currentNode.data[i].compareTo(valueToSearch) == 0)
				return true;

			if (currentNode.data[i].compareTo(valueToSearch) > 0) {
				currentNode = currentNode.children[i];
			} else {
				currentNode = currentNode.children[i + 1];
			}

			return contains(currentNode, valueToSearch);

		}
		return false;
	}


	public int size() {
		if (isEmpty()) {
			return 0;
		}

		return size(this.root);

	}

	private int size(Node currentNode) {
		int size = currentNode.numberOfData;
		int index = 0;

		while (index < currentNode.children.length && currentNode.children[index] != null) {
			size += size(currentNode.children[index]);
			index++;
		}

		return size;
	}


	public int height() {
		Node currentNode = this.root;
		int height = 0;
		while (currentNode != null) {
			currentNode = currentNode.children[0];
			height++;
		}

		return height;
	}


	public Comparable getMax() {
		if (isEmpty())
			return null;
		return getMax(this.root);
	}

	private Comparable getMax(Node currentNode) {
		if (currentNode.isLeaf) {
			return currentNode.data[currentNode.numberOfData - 1];
		} else {
			int index = 0;
			while (index + 1 < currentNode.children.length && currentNode.children[index + 1] != null) {
				index++;
			}
			return (getMax(currentNode.children[index]));
		}
	}


	public Comparable getMin() {
		if (isEmpty())
			return null;
		return getMin(this.root);
	}

	private Comparable getMin(Node currentNode) {
		if (currentNode.isLeaf) {
			return currentNode.data[0];
		} else
			return (getMin(currentNode.children[0]));
	}


	public Comparable[] getAll() {
		this.dataIndex = 0;
		Comparable[] data = new Comparable[this.size()];
		getAll(data);

		return data;
	}

	private void getAll(Comparable[] data) {
		int height = this.height();

		for (int i = 1; i <= height; i++) {
			getGivenLevel(this.root, i, data);

		}
	}

	private void getGivenLevel(Node currentNode, int level, Comparable[] data) {
		if (currentNode == null)
			return;
		if (level == 1)
			for (int i = 0; i < currentNode.numberOfData; i++, this.dataIndex++) {
				data[dataIndex] = currentNode.data[i];
			}
		else if (level > 1) {
			for (int i = 0; i < 2 * order + 1 && currentNode.children[i] != null; i++) {
				getGivenLevel(currentNode.children[i], level - 1, data);
			}
		}
	}

	public boolean isEmpty() {
		return this.root == null;
	}


	public void addAll(BTree2 otherTree) {
		if (otherTree != null) {
			Comparable[] data = otherTree.getAll();

			for (Comparable current : data) {
				this.insert(current);
			}
		}
	}


	public void printInorder() {
		if (!isEmpty()) {
			printInorder(this.root);
			println();
		}
	}

	private void printInorder(Node currentNode) {
		if (currentNode != null) {
			for (int i = 0; i < currentNode.children.length; i++) {
				if (currentNode.children[i] != null) {
					printInorder(currentNode.children[i]);
				}

				if (i < currentNode.numberOfData) {
					System.out.print(" " + currentNode.data[i] + " ");
				}
			}
		}
	}

	public void printPostorder() {
		if (!isEmpty()) {
			printPostorder(this.root);
			println();
		}
	}

	private void printPostorder(Node currentNode) {
		if (!currentNode.isLeaf) {
			for (int i = 0; i < currentNode.children.length; i++) {
				if (currentNode.children[i] != null)
					printPostorder(currentNode.children[i]);
			}
		}
		printDataofNode(currentNode);

	}


	public void printPreorder() {
		if (!isEmpty()) {
			printPreorder(this.root);
			println();
		}
	}

	private void printPreorder(Node currentNode) {
		if (currentNode != null) {
			printDataofNode(currentNode);

			for (int i = 0; i < currentNode.children.length; i++) {
				if (currentNode.children[i] != null)
					printPreorder(currentNode.children[i]);
			}
		}
	}


	public void printLevelorder() {
		int height = this.height();
		for (int i = 1; i <= height; i++) {
			printGivenLevel(this.root, i);
			System.out.println();
		}
	}

	private void printGivenLevel(Node currentNode, int level) {
		if (currentNode == null)
			return;
		if (level == 1)
			printDataofNode(currentNode);
		else if (level > 1) {
			for (int i = 0; i < 2 * order + 1 && currentNode.children[i] != null; i++) {
				printGivenLevel(currentNode.children[i], level - 1);
			}
		}
	}

	private void printDataofNode(Node node) {
		for (int i = 0; i < node.numberOfData; i++) {
			System.out.print(node.data[i] + " ");
		}
		System.out.print("    ");
	}

	@Override
	public BTree2 clone() {
		BTree2 clone = new BTree2(this.order);

		if (this.root == null) {
			return clone;
		}

		clone.root = cloneNode(this.root, null);

		return clone;
	}

	private Node cloneNode(Node toClone, Node clonedParent) {

		Node clone = new Node((toClone.data.length - 1) / 2, clonedParent, toClone.isLeaf);

		clone.data = toClone.data.clone();
		clone.numberOfData = toClone.numberOfData;

		for (int i = 0; i < toClone.children.length; i++) {
			if (toClone.children[i] != null) {
				clone.children[i] = cloneNode(toClone.children[i], clone);
			}
		}

		return clone;
	}

}
