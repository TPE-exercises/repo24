package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

public interface BTree {

	/**
	 * insert an Integer object into the tree. 
	 * @param Integer to insert
	 * @return true if the insertion was successful and false if and Integer with this value is already in the tree
	 */
	boolean insert(Integer o);
	
	
	/**
	 * insert all values that are stored in the file into the tree. Duplicates are not added.
	 * @param filename 
	 * @return true if the specified file could be opened, else false.
	 */
	boolean insert(String filename);
	
	/**
	 * The tree is searched for the passed value
	 * @param o
	 * @return true if an object with the passed value is present, else false is returned
	 */
	boolean contains(Integer o);
	
	/** 
	 * @return how many Integer objects are stored in the tree
	 */
	int size();
	
	/**
	 * if the tree is empty the height is 0, if there is only a root node the height is 1
	 * @return the height of the tree
	 */
	int height();
	
	/**
	 * returns the Integer with the highest value in the tree. If the tree is empty null is returned.
	 * @return
	 */
	Integer getMax();
	
	/**
	 * returns the Integer with the lowest value in the tree. If the tree is empty null is returned.
	 * @return
	 */
	Integer getMin();
	
	/**
	 * Get all data in level order
	 * @return
	 */
	Integer[] getAll();
	
	/**
	 * True if there are no elements in the tree. If at least one element is in the tree, false is returned.
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * add all values of the Integer objects in otherTree into the Tree. Duplicates are not added.
	 * @param otherTree
	 */
	void addAll(BTree otherTree);
	
	/**
	 * prints the tree to the console in order.
	 */
	void printInorder();
	
	/**
	 * prints the tree to the console in post order
	 */
	void printPostorder();
	
	/**
	 *  prints the tree to the console in pre order
	 */
	void printPreorder();
	
	/**
	 * prints the tree to the console in level order
	 */
	void printLevelorder();
	
	/**
	 * 
	 * @return a deep copy of the tree
	 */
	BTree clone();
	
}
