package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

import static gdi.MakeItSimple.*;

public class BTreeMenu {
	static BTree tree1;
	static BTree tree2;
	static BTree tree3;
	
	static BTree currentTree;
	
	public static void main(String[] args) {

		currentTree = tree1;
		
		while (true) {
			makeMenu();
		}

	}

	public static void makeMenu() {

		println("------------------- Menü -------------------");
		println("1: Create new BTree"); // calls method toString
		println("2: boolean insert(Integer o)");
		println("3: boolean insert(String filename)");
		println("4: boolean contains(Integer o)");
		println("5: int size()");
		println("6: int height()");
		println("7: Integer getMax()");
		println("8: Integer getMin()");
		println("9: boolean isEmpty()");
		println("10: void addAll(Btree otherTree)");
		println("11: void printInorder()");
		println("12: void printPostorder()");
		println("13: void printPreorder()");
		println("14: void printLevelorder()");
		println("15: BTree clone()");
		println("16: change working tree"); // sets another list as working list

		int selection = readInt();

		switch (selection) {
		case 1:
			println("Enter order of BTree:");
			currentTree = new MyBTree(readInt());
			break;
		case 2:
			if(currentTree != null){
			println("Enter value to insert:");
			println(currentTree.insert(readInt()));
			} else {
				println("The working tree is not initialised");
			}
			
			break;
		case 3:
			if(currentTree != null){
			println("Enter the path of the file to insert:");
			println(currentTree.insert(readLine()));
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 4:
			if(currentTree != null){
			println("Enter value to search for:");
			println(currentTree.contains(readInt()));
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 5:
			if(currentTree != null){
			println(currentTree.size());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 6:
			if(currentTree != null){
			println(currentTree.height());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 7:
			if(currentTree != null){
			println(currentTree.getMax());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 8:
			if(currentTree != null){
			println(currentTree.getMin());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 9:
			if(currentTree != null){
			println(currentTree.isEmpty());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 10:
			if(currentTree != null){
			println("Enter the index of the tree to add:");
			int index = readInt();
			BTree otherTree = new MyBTree(1);
			if(index == 1) 
				otherTree = tree1;
			if(index == 2) 
				otherTree = tree2;
			if(index == 1) 
				otherTree = tree3;
			currentTree.addAll(otherTree);
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 11:
			if(currentTree != null){
			currentTree.printInorder();
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 12:
			if(currentTree != null){
				currentTree.printPostorder();
				} else {
					println("The working tree is not initialised");
				}
			break;
		case 13:
			if(currentTree != null){
				currentTree.printPreorder();
				} else {
					println("The working tree is not initialised");
				}
			break;
		case 14:
			if(currentTree != null){
				currentTree.printLevelorder();
				} else {
					println("The working tree is not initialised");
				}
			break;
		case 15:
			println("Clone current tree to which index?");
			int clone = readInt();
			if(clone == 1) 
				tree1 = currentTree.clone();
			if(clone == 2) 
				tree2 = currentTree.clone();
			if(clone == 1) 
				tree3 = currentTree.clone();
			break;
			
			
		case 16:
			println("Enter index of tree to change to (1 - 3), default is 1:");
			int index = readInt();
			if(index == 1) 
				currentTree = tree1;
			if(index == 2) 
				currentTree = tree2;
			if(index == 1) 
				currentTree = tree3;
			
			break;
		default:
			break;
		}
		readLine();
	}
}