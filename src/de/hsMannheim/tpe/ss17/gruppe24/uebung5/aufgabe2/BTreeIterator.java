package de.hsMannheim.tpe.ss17.gruppe24.uebung5.aufgabe2;


import java.util.*;

/**
 * Used to iterate over a BTree. Pass an array with the contents of the BTree
 * @author Jacob
 *
 */
public class BTreeIterator<T extends Comparable<T>> implements Iterator<T> {

	private Comparable<T>[] data;
	private int counter;
	
	public BTreeIterator(Comparable<T>[] data) {
		this.data = data;
		this.counter = 0;
	}

	@Override
	public boolean hasNext() {
		return counter < data.length;
	}

	@Override
	public T next() throws NoSuchElementException {
		if(hasNext()){
			return (T)data[counter++];
		}
		throw new NoSuchElementException();
	}

}
