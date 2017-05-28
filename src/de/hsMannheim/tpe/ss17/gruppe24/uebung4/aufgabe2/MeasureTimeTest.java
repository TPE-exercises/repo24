package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MeasureTimeTest {

	Integer[] array;
	
	@Before
	public void initialise(){
		array = new Integer[]{3, 5, 23, 1, 6, 12, 2, 76, 222, 566};
	}
	
	@Test
	public void sequentialTest() {
		SortAlgorithm sorter = new SequentialQuickSort();
		
		long startTime = System.nanoTime();		
		sorter.sort(array);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("Sequential sort time in nanos: " + elapsedTime);
	}
	
	@Test
	public void parallelTest() {
		SortAlgorithm sorter = new ParallelQuickSort();
		
		long startTime = System.nanoTime();		
		sorter.sort(array);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("Parallel sort time in nanos: " + elapsedTime);
	}

}
