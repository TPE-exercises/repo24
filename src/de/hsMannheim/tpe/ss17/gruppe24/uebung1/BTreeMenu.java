package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

import static gdi.MakeItSimple.*;

public class BTreeMenu {
	static BTree tree1;
	static BTree tree2;

	public static void main(String[] args) {

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
		println("10: void addAll(Btree otherTree");
		println("11: void printInorder()");
		println("12: void printPostorder()");
		println("13: void printPreorder()");
		println("14: void printLevelorder()");
		println("15: change working tree"); // sets another list as working list

		int selection = readInt();

		switch (selection) {
		case 1:
			// your code here
			break;
		case 2:
			// your code here
			break;
		case 3:
			// your code here
			break;
		case 4:

			break;
		case 5:
			// your code here
			break;
		case 6:
			// your code here
			break;
		case 7:
			// your code here
			break;
		case 8:
			// your code here
			break;
		case 9:
			// your code here
			break;
		case 10:
			// your code here
			break;
		case 11:
			// your code here
			break;
		case 12:
			// your code here
			break;
		case 13:
			// your code here
			break;
		case 14:
			// your code here
			break;
		case 15:
			// your code here
			break;
		default:
			break;
		}
		readLine();
	}
}