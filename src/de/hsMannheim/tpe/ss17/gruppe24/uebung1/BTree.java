package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

public interface BTree {

	boolean insert(Integer o);
	boolean insert(String filename);
	boolean contains(Integer o);
	int size();
	int height();
	Integer getMax();
	Integer getMin();
	
	/**
	 * Get all data in level order
	 * @return
	 */
	Integer[] getAll();
	
	boolean isEmpty();
	void addAll(BTree otherTree);
	
	void printInorder();
	void printPostorder();
	void printPreorder();
	void printLevelorder();
	
	
}
