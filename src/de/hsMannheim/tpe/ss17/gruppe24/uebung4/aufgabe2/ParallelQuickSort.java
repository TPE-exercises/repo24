package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe2;

public class ParallelQuickSort implements SortAlgorithm {

	public static int recursionSteps, swaps, comparisons, threads, joinings;

	public ParallelQuickSort() {
		super();
		recursionSteps = 0;
		swaps = 0;
		comparisons = 0;
		threads = 0;
		joinings = 0;
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

	private static void swap(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		swaps++;
	}

	protected static void parallelQuickSort(Comparable[] array, int lowBound, int highBound) {


		
		if (highBound > lowBound) {
			int index = split(array, lowBound, highBound);
			//printArray(array);
			
			Thread lowerThread = new Thread(new SorterRunnable(array, lowBound, index - 1));
			Thread upperThread = new Thread(new SorterRunnable(array, index + 1, highBound));
			threads += 2;

			lowerThread.start();
			upperThread.start();

			try {
				lowerThread.join();
				upperThread.join();
				joinings++;
			} catch (InterruptedException e) {
				System.out.println("You should not see this message.");
			}

		}

		recursionSteps = (int) (Math.log10(threads) / Math.log10(2));
	}

	@Override
	public void sort(Comparable[] array) {
		parallelQuickSort(array, 0, array.length - 1);
	}

	public static synchronized void printArray(Comparable[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++)
			System.out.print(array[i] + ", ");
		System.out.print(array[array.length - 1] + "]\n");
	}
	
	public static void printStats(){
		System.out.println("recursion steps: "+ recursionSteps);
		System.out.println("swaps: "+ swaps);
		System.out.println("comparisons: "+ comparisons);
		System.out.println("threads: " + threads);
		System.out.println("joinings: " + joinings);
	}
	
	public static void resetStats(){
		recursionSteps = 0;
		swaps = 0;
		comparisons = 0;
		threads = 0;
		joinings = 0;
	}
	
}
