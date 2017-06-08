package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe3;

public class RingBuffer {
	private Comparable[] array;
	private int start, end;

	public RingBuffer(int arraySize) {
		this.array = new Comparable[arraySize];
	}
	
	public boolean isFull(){
		return(end + 1) % array.length == start;
	}
	
	public boolean isEmpty(){
		return(start == end);
	}

	public synchronized void put(Comparable toInsert){
		while(isFull()){
			try{
				wait();
			} catch(InterruptedException e){
				//System.out.println("put() interrupted");
			}
		}
		
		if (array[end] == null) {
			array[end] = toInsert;
		} else {
			end = (end + 1) % array.length;
			array[end] = toInsert;
		}
		notifyAll();
	}

	public synchronized Comparable get(){
		while(isEmpty()){
			try{
				wait();
			} catch(InterruptedException e){
				//System.out.println("get() interrupted");
			}
		}
		
		Comparable temp = array[start];
		start = (start + 1) % array.length;
		notifyAll();
		return temp;
	}

}
