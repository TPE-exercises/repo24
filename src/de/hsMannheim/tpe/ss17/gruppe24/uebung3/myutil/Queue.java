package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

public interface Queue {

	/**
	 * add an Object to the queue
	 * 
	 * @throws Exception
	 *             in case of overflow
	 */
	void enter(Object toInsert) throws Exception;

	/**
	 * remove the first object of the queue and return it
	 * 
	 * @return
	 * @throws Exception
	 *             in case of underflow
	 */
	Object leave() throws Exception;

	/**
	 * return the first element in the list without removing it
	 * @return
	 * @throws Exception if queue is empty
	 */
	Object front() throws Exception;

	/**
	 * empty the queue
	 */
	void empty();
	
	/**
	 * returns true if the queue is empty
	 * 
	 * @return
	 */
	boolean isEmpty();
}
