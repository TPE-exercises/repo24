package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe2;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] array = {5, 25, 3, 19, 33, 2, 23423, 234, 1, 8 ,23 , 43 , 123, 12};
		ParallelQuickSort sorter = new ParallelQuickSort();
		sorter.sort(array);
		ParallelQuickSort.printArray(array);
		ParallelQuickSort.printStats();
	}

}
