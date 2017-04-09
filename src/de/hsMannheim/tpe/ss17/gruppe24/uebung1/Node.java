package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

public class Node {

	Integer[] data;
	int numberOfData; //number of objects in data[]
	Node[] children;
	boolean isLeaf;
	Node parent;
	
	public Node(int order, Node parent){
		this.isLeaf = true;
		this.data = new Integer[2 * order + 1];
		this.children = new Node[2 * order + 2]; 
		this.parent = parent;	
	}
	
	public Node(int order, Node parent, boolean isLeaf){
		this(order, parent);
		this.isLeaf = isLeaf;
	}

}
