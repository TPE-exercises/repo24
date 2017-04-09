package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

import static gdi.MakeItSimple.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BTreeTest {

	@Test
	public void isEmptyTest() {
		BTree testTree = new MyBTree(2);
		
		assertTrue(testTree.isEmpty());
		
		testTree.insert(new Integer(123));
		
		assertFalse(testTree.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		BTree testTree = new MyBTree(2);
		
		testTree.insert(new Integer(1));
		testTree.insert(new Integer(2));
		testTree.insert(new Integer(3));
		
		assertEquals(3, testTree.size());
	}
	
	@Test
	public void containsTest() {
		BTree testTree = new MyBTree(2);
		
		assertTrue(testTree.insert(new Integer(1)));
		assertTrue(testTree.insert(new Integer(2)));
		assertTrue(testTree.insert(new Integer(3)));
		assertFalse(testTree.insert(new Integer(3)));
		
		assertTrue(testTree.contains(new Integer(1)));
		assertTrue(testTree.contains(new Integer(2)));
		assertTrue(testTree.contains(new Integer(3)));
		assertFalse(testTree.contains(new Integer(5)));
		
	}
	
	@Test
	public void getMaxTest(){
		BTree testTree = new MyBTree(2);
		
		assertEquals(null, testTree.getMax());
		
		testTree.insert(new Integer(1));
		testTree.insert(new Integer(5));
		testTree.insert(new Integer(9));
		
		assertEquals(new Integer(9), testTree.getMax());
	}
	
	@Test
	public void getMinTest(){
		BTree testTree = new MyBTree(2);
		
		assertEquals(null, testTree.getMin());
		
		testTree.insert(new Integer(1));
		testTree.insert(new Integer(5));
		testTree.insert(new Integer(9));
		
		assertEquals(new Integer(1), testTree.getMin());
	}
	
	@Test
	public void addAllTest(){
		BTree testTree1 = new MyBTree(2);
		testTree1.insert(new Integer(1));
		testTree1.insert(new Integer(2));
		
		BTree testTree2 = new MyBTree(2);
		testTree2.insert(new Integer(3));
		testTree2.insert(new Integer(4));
		
		testTree1.addAll(testTree2);

		assertTrue(testTree1.contains(new Integer(1)));
		assertTrue(testTree1.contains(new Integer(2)));
		assertTrue(testTree1.contains(new Integer(3)));
		assertTrue(testTree1.contains(new Integer(4)));
	}
	
	@Test
	public void addAllFileTest(){

		String fileName = "values.txt";
		
		if(!isFilePresent(fileName)){
			return;
		}
		
		
		BTree testTree = new MyBTree(2);
		testTree.insert(fileName);

		
		Object file = openInputFile(fileName);
		
		while(!isEndOfInputFile(file)){
			assertTrue(testTree.contains(new Integer(readInt(file))));
		}
	}
	
	@Test
	public void hightTest(){
		BTree testTree = new MyBTree(2);
		
		assertEquals(0, testTree.height());
		
		testTree.insert(new Integer(1));
		
		assertEquals(1, testTree.height());
		
		testTree.insert(new Integer(2));
		testTree.insert(new Integer(3));
		testTree.insert(new Integer(4));
		testTree.insert(new Integer(5));
		testTree.insert(new Integer(6));
		
		assertEquals(2, testTree.height());
	}
	

}