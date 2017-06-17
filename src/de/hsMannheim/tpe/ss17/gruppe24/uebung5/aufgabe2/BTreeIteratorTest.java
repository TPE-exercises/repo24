package de.hsMannheim.tpe.ss17.gruppe24.uebung5.aufgabe2;

public class BTreeIteratorTest {

	public static void main(String[] args) {
		BTree2<Integer> tree = new BTree2(2);
		tree.insert(4);
		tree.insert(6);
		tree.insert(10);

		
		for(Integer i : tree){
			System.out.println(i);
		}
		
		tree.insert(234);
		
		for(Integer i : tree){
			System.out.println(i);
		}
		
	}

}
