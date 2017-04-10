package de.hsMannheim.tpe.ss17.gruppe24.uebung1;

import static gdi.MakeItSimple.*;

public class BTreeMenu {

	static BTree[] workingTree;

	static int treeIndex;

	public static void main(String[] args) {

		workingTree = new BTree[3];
		workingTree[0] = new MyBTree(1);
		workingTree[1] = new MyBTree(1);
		workingTree[2] = new MyBTree(1);

		treeIndex = 0;

		while (true) {
			makeMenu();
		}

	}

	public static void makeMenu() {

		println("------------------- Menü -------------------");
		println("current working tree: " + treeIndex);

		println("1: Create new BTree at index " + treeIndex);
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
		println("16: change working tree");

		int selection = readInt();

		switch (selection) {
		case 1:
			println("Enter order of BTree:");
			workingTree[treeIndex] = new MyBTree(readInt());
			break;
		case 2:
			if (workingTree[treeIndex] != null) {
				println("Enter value to insert:");
				println(workingTree[treeIndex].insert(readInt()));
			} else {
				println("The working tree is not initialised");
			}

			break;
		case 3:
			if (workingTree[treeIndex] != null) {
				readLine();
				println("Enter the path of the file to insert:");
				println(workingTree[treeIndex].insert(readLine()));
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 4:
			if (workingTree[treeIndex] != null) {
				println("Enter value to search for:");
				println(workingTree[treeIndex].contains(readInt()));
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 5:
			if (workingTree[treeIndex] != null) {
				println(workingTree[treeIndex].size());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 6:
			if (workingTree[treeIndex] != null) {
				println(workingTree[treeIndex].height());
			} else {
				println("The working tree is not initialised");
			}
			break;

		case 7:
			if (workingTree[treeIndex] != null) {
				Integer max = workingTree[treeIndex].getMax();

				if (max != null) {
					println(max);
				} else {
					println("Could not get max, tree is empty!");
				}
			} else {
				println("The working tree is not initialised");
			}
			break;

		case 8:
			if (workingTree[treeIndex] != null) {
				Integer min = workingTree[treeIndex].getMin();

				if (min != null) {
					println(min);
				} else {
					println("Could not get min, tree is empty!");
				}
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 9:
			if (workingTree[treeIndex] != null) {
				println(workingTree[treeIndex].isEmpty());
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 10:
			if (workingTree[treeIndex] != null) {
				println("Enter the index of the tree to add:");
				int index = readInt();
				workingTree[treeIndex].addAll(workingTree[index]);
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 11:
			if (workingTree[treeIndex] != null) {
				workingTree[treeIndex].printInorder();
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 12:
			if (workingTree[treeIndex] != null) {
				workingTree[treeIndex].printPostorder();
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 13:
			if (workingTree[treeIndex] != null) {
				workingTree[treeIndex].printPreorder();
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 14:
			if (workingTree[treeIndex] != null) {
				workingTree[treeIndex].printLevelorder();
			} else {
				println("The working tree is not initialised");
			}
			break;
		case 15:
			println("Clone current tree to which index?");
			int clone = readInt();
			if (clone < 0 || clone > 2) {
				println("index out of bounds.");
				break;
			}
			workingTree[clone] = workingTree[treeIndex].clone();
			break;

		case 16:
			println("Enter index of tree to change to (0 - 2)");
			int index = readInt();
			if (index < 0 || index > 2) {
				println("index out of bounds.");
				break;
			} else
				treeIndex = index;
			break;
		default:
			break;
		}
		readLine();
	}
}