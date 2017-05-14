package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

public interface Stack {

	/**
	 * add a new object to the stack
	 * throw an appropriate exception if an overflow
	 * occurs.
	 * @param toInsert
	 */
	void push(Object toInsert) throws Exception;
	
	/**
	 * remove the top object in stack and return it
	 * throw an appropriate exception in case of underflow
	 * @return
	 */
	Object pop() throws Exception;
	
	/**
	 * return the top object without removing it
	 * null if stack is empty
	 * @return
	 */
	Object top() throws Exception;
	
	/**
	 * empty the stack
	 */
	void empty();
	
	/**
	 * true if the stack is empty
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * return the amount of Objects in the stack
	 * @return 
	 */
	int size();
}

