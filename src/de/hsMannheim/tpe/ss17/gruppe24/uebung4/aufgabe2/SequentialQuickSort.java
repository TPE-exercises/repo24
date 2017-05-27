package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe2;

public class SequentialQuickSort implements SortAlgorithm {

	
	public SequentialQuickSort(){
		super();
	}
	
	private static int split(Comparable[] array, int lowBound, int highBound){
		
		int pivot = highBound;
		int index = lowBound;
		
		for(int pointer = lowBound; pointer < highBound; pointer++){
			if(array[pointer].compareTo(array[pivot]) <= 0){
				swap(array, pointer, index);
				index++;
			}
		}
		
		swap(array, index, pivot);
		return index;
	}
	


	private static void swap(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}



	private static void quicksort(Comparable[] array, int lowBound, int highBound){
		if(highBound > lowBound){
			int index = split(array, lowBound, highBound);
			quicksort(array, lowBound, index - 1);
			quicksort(array, index + 1, highBound);
		}
	}

	@Override
	public void sort(Comparable[] array) {
		quicksort(array, 0, array.length - 1);
	}
}
