package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe2;

public class SequentialQuickSort implements SortAlgorithm {

	static int recursionCalls, recursionSteps, swaps, comparisons;

	public SequentialQuickSort() {
		super();
		recursionCalls = 0;
		recursionSteps = 0;
		swaps = 0;
		comparisons = 0;
	}

	private static int split(Comparable[] array, int lowBound, int highBound) {

		int pivot = highBound;
		int index = lowBound;

		for (int pointer = lowBound; pointer < highBound; pointer++, comparisons++) {
			if (array[pointer].compareTo(array[pivot]) <= 0) {
				swap(array, pointer, index);
				index++;
			}
		}

		swap(array, index, pivot);
		return index;
	}

	/**
	 * All elements left of pivot are now smaller, all to the right are larger
	 * 
	 * @param array
	 * @param lowBound
	 * @param highBound
	 * @return the index of the pivot element
	 */
	private static void swap(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		swaps++;
	}

	/**
	 * Split the array and recursively call quicksort on the parts
	 * 
	 * @param array
	 * @param lowBound
	 * @param highBound
	 */
	private static void quicksort(Comparable[] array, int lowBound, int highBound) {
		if (highBound > lowBound) {
			int index = split(array, lowBound, highBound);
			quicksort(array, lowBound, index - 1);
			quicksort(array, index + 1, highBound);
			recursionCalls += 2;
		}
		recursionSteps = (int) (Math.log10(recursionCalls) / Math.log10(2));
	}

	@Override
	public void sort(Comparable[] array) {
		quicksort(array, 0, array.length - 1);
	}

	/**
	 * Print the array to the console
	 * 
	 * @param array
	 */
	public static void printArray(Comparable[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.print(array[array.length - 1] + "]\n");
	}

	/**
	 * Print statistics to the console
	 */
	public static void printStats() {
		System.out.println("recursion steps: " + recursionSteps);
		System.out.println("swaps: " + swaps);
		System.out.println("comparisons: " + comparisons);

	}

	/**
	 * reset the stats
	 */
	public static void resetStats() {
		recursionSteps = 0;
		swaps = 0;
		comparisons = 0;
	}

}
