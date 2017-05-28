package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe2;

public class SorterRunnable implements Runnable {

	
	private Comparable[] array;
	private int lowBound, highBound;
	
	public SorterRunnable(Comparable[] array, int lowBound, int highBound){
		this.array = array;
		this.lowBound = lowBound;
		this.highBound = highBound;
	}
	
	@Override
	public void run() {
		ParallelQuickSort.parallelQuickSort(array, lowBound, highBound);
	}

}
