package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt2;

import static gdi.MakeItSimple.*;

public class SortingTest {

	public static MyInt[] createRandomArrayInt(int size){
	
		MyInt[] array = new MyInt[size];
		
		for(int i = 0; i != array.length; i++){
			array[i] = new MyInt((int)(Math.random() * 100.0));
		}
		
		return array;
	}
	
	public static MyString[] createRandomArrayString(int size){
		
		MyString[] array = new MyString[size];
		
		for(int i = 0; i != array.length; i++){
			String string = new String();
			
			for(int j = 0; j < 10; j++){
				double random = Math.random();
				
				if(random > 2.0/3.0){
					string += (char)('a' + (int)(Math.random() * ('z' - 'a') + 0.5));
				}
				else if(random > 1.0/3.0){
					string += (char)('A' + (int)(Math.random() * ('Z' - 'A') + 0.5));
				}
				else{
					string += (char)('0' + (int)(Math.random() * ('9' - '0') + 0.5));
				}		
			}
			
			array[i] = new MyString(string);
		}
		
		return array;
	}
	
	public static void printArray(Object[] array){
		for(int i = 0; i != array.length; i++){
			println(array[i]);
		}
		println();
	}
	
	public static void sortArray(Sorter sorter, Comparable[] array){
		println("Sorting Array with " + sorter.toString());
		println("Before sorting:");
		printArray(array);
		sorter.Sort(array);
		println("After sorting:");
		printArray(array);
	}
	
	public static void main(String[] args) {
		
		Sorter shakerSorter = new ShakerSorter();
		Sorter insertionSorter = new InsertionSorter();
		
		MyInt[] randomIntArray = createRandomArrayInt(5);
		MyInt[] intArr = null;
		
		intArr = randomIntArray.clone();
		sortArray(shakerSorter, intArr);

		intArr = randomIntArray.clone();
		sortArray(insertionSorter, intArr);
		
		
		
		MyString[] randomStringArray = createRandomArrayString(5);
		MyString[] stringArray = null;
		
		stringArray = randomStringArray.clone();
		sortArray(shakerSorter, stringArray);

		stringArray = randomStringArray.clone();
		sortArray(insertionSorter, stringArray);
	}

}
