package de.hsMannheim.tpe.gruppe24.ss17.uebung2.blatt2;

public class ShakerSorter implements Sorter {

	@Override
	public void Sort(Comparable[] array) {

		boolean swap = false;
				
		int left = 0;
		int right = array.length - 1;
		
		//as long as a swap occurs the sort proceeds
		do {
			swap = false;
			
			//move through the array from lowest to highest index
			//swap if a smaller value is on the right of current position
			for (int i = left; i < right; i++) {

				if (array[i].compareTo(array[i + 1]) > 0) {

					Comparable tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;

					swap = true;
				}
			}
			right--;
			
			if(!swap) break;
			swap = false;
			
			//move through the array from highest to lowest index
			//swap if a smaller value is on the right of current position
			for (int i = right; i >=  left; i--) {
				if (array[i].compareTo(array[i + 1]) > 0) {

					Comparable tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					
					swap = true;
				}	
			}
			left++;
		
		} while (swap);
	}
}
