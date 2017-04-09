package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

import static gdi.MakeItSimple.*;

public class BTreeTest {

	public static void main(String[] argv){
		BTree myTree = new MyBTree(4);
		//myTree.insert("./values.txt");

		for(int i = 0; i < 100; i++){
			myTree.insert(i);
		}
		
		int counter = 0;
		
		
		BTree otherTree = new MyBTree(4);
		otherTree.addAll(myTree);
		
		myTree.printLevelorder();
		otherTree.printLevelorder();
		
		println();
		println(counter);
		
		//print(myTree.getMin());
	}

}