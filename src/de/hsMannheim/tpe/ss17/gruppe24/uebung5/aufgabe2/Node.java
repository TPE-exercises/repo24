package de.hsMannheim.tpe.ss17.gruppe24.uebung5.aufgabe2;

public class Node<T extends Comparable<T>> {

	Comparable<T>[] data;
	int numberOfData; //number of objects in data[]
	Node<T>[] children;
	boolean isLeaf;
	Node<T> parent;
	
	public Node(int order, Node<T> parent){
		this.isLeaf = true;
		this.data = new Comparable[2 * order + 1];
		this.children = new Node[2 * order + 2]; 
		this.parent = parent;	
	}
	
	public Node(int order, Node<T> parent, boolean isLeaf){
		this(order, parent);
		this.isLeaf = isLeaf;
	}

}
