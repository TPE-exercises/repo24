package de.hsMannheim.tpe.ss17.gruppe24.uebung5.aufgabe3;

import java.util.*;
import java.io.*;

public class WordCounter {

	/**
	 * Ask user to Input a file path
	 * @return File object
	 */
	public static File InputFile() {
		Scanner input = new Scanner(System.in);
		File file;
		
		while(true){

			System.out.print("Enter path to file: ");
			file = new File(input.nextLine());
			
			if(!file.exists()){
				System.out.println("This file doesn't exist!");
				continue;
			}
			
			break;
		}
		
		input.close();
		return file;
	}

	/**
	 * Add all words in a text file to a Map
	 * keys = word, values = count
	 * @throws FileNotFoundException 
	 */
	public static Map<String, Integer> CreateWordMap(File file){
		
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		try {
			Scanner input = new Scanner(file);
			
			input.useDelimiter("\\s+"); // Use whitespace as Delimiter

			while (input.hasNext()) {
				String word = input.next();

				word = word.toLowerCase(); // Convert to LowerCase since we want to ignore upper-/lowercase
				word = word.replaceAll("\\p{Punct}+", ""); // remove punctuation marks

				if (word.isEmpty())
					continue;

				Integer count = wordMap.get(word);
				if (count == null) {
					wordMap.put(word, 1); // word is not in our map, so add it and set count to 1
				} else {
					wordMap.put(word, count + 1); // word is in our map, increment count
				}
			}

			input.close();
		} 
		catch (FileNotFoundException e) {
		}
		
		return wordMap;
	}
	
	
	public static void main(String[] args) {

		// Test Files:
		// src/de/hsMannheim/tpe/ss17/gruppe24/uebung5/aufgabe3/bibel.txt
		// src/de/hsMannheim/tpe/ss17/gruppe24/uebung5/aufgabe3/shakespeare.txt
		// src/de/hsMannheim/tpe/ss17/gruppe24/uebung5/aufgabe3/test.txt
		
		File file = InputFile();
		
		System.out.println("Counting words...");

		long time = System.currentTimeMillis();

		Map<String, Integer> wordMap = CreateWordMap(file);

		long curTime = System.currentTimeMillis();
		System.out.println("Counting all Words took " + (curTime - time) + "ms");
		time = curTime;

		
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());

		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int cmp = o2.getValue().compareTo(o1.getValue());
				if(cmp == 0){
					return o1.getKey().compareTo(o2.getKey());
				}
				return cmp;
			}
		});
		


		curTime = System.currentTimeMillis();
		System.out.println("Sorting the generated List took" + (curTime - time) + "ms");

		for (int i = 0; i < 100 && i < list.size(); i++) {

			Map.Entry<String, Integer> entry = list.get(i);

			System.out.println(i + 1 + ". Count:" + entry.getValue() + " World:" + entry.getKey());
		}

	}

}
