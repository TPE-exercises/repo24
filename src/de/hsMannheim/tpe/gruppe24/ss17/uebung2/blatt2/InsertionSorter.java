package de.hsMannheim.tpe.gruppe24.ss17.uebung2.blatt2;

public class InsertionSorter implements Sorter {

	@Override
	public void Sort(Comparable[] array) {

		for (int i = 1; i < array.length; i++) {

			int j = i;
			Comparable marker = array[i];
			
			//check if element needs to be moved to make room for insert element 
			while (j > 0 && array[j - 1].compareTo(marker) > 0) 
			{
				array[j] = array[j - 1];
				j--;
			}

			array[j] = marker;
		}
	}
}
