package de.hsMannheim.tpe.ss17.gruppe24.uebung3;

import de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil.*;
import static gdi.MakeItSimple.*;

public class MyutilMenu {

	public static void stackMenu(String type, int size) {

		Stack stack = null;

		if (type.equals("array")) {
			stack = new ArrayStack(size);
		}

		else if (type.equals("list")) {
			stack = new ListStack(size);
		} else
			return;

		while (true) {

			println("1: push Integer");
			println("2: push String");
			println("3: pop");
			println("4: top");
			println("5: empty the stack");
			println("6: isEmpty");
			println("7: print");
			println("8: size");

			int input = readInt();
			readLine();
			
			switch (input) {
			case 1:
				println("enter an Integer value:");
				try {
					int toInsert = readInt();
					readLine();
					
					stack.push(new Integer(toInsert));
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}


				break;
			case 2:
				println("enter a String:");
				try {
					stack.push(readLine());
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}


				break;
			case 3:
				try {
					println(stack.pop() + " has been popped.");
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}


				break;
			case 4:
				try {
					println(stack.top() + " is at the top.");
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}


				break;
			case 5:
				stack.empty();
				println("stack has been emptied.");
				break;
			case 6:
				println("isEmpty() = " + stack.isEmpty());
				break;
			case 7:
				println(stack.toString());
				break;
			case 8:
				println("size = " + stack.size());

			}
		}

	}

	public static void queueMenu(String type, int size) {
		Queue queue = null;

		if (type.equals("array")) {
			queue = new ArrayQueue(size);
		}

		else if (type.equals("list")) {
			queue = new ListQueue(size);
		} else
			return;

		while (true) {

			println("1: enter Integer");
			println("2: enter String");
			println("3: leave");
			println("4: front");
			println("5: empty the queue");
			println("6: isEmpty");
			println("7: print");
			println("8: size");

			int input = readInt();
			readLine();
			
			switch (input) {
			case 1:
				println("enter an Integer value:");
				try {
					int toEnter = readInt();
					readLine();
					
					queue.enter(new Integer(toEnter));
					
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}


				break;
			case 2:
				println("enter a String:");
				try {
					queue.enter(readLine());
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}



				break;
			case 3:
				try {
					println("[" + queue.leave() + "] has been removed.");
				} catch (Exception e) {
					e.printStackTrace();
					readLine();
				}


				break;
			case 4:
				try {
					println("[" + queue.front() + "] is at the front.");
				} catch (Exception e) {
					e.printStackTrace();

				}


				break;
			case 5:
				queue.empty();
				println("queue has been emptied.");
				break;
			case 6:
				println("isEmpty() = " + queue.isEmpty());
				break;
			case 7:
				println(queue.toString());
				break;
			case 8:
				println("size = " + queue.size());

			}
		}

	}

	public static void main(String[] argv) {

		println("1: ListStack");
		println("2: ArrayStack");
		println("3: ListQueue");
		println("4: ArrayQueue");

		int input = readInt();

		switch (input) {
		case 1:
			println("enter the size of the stack:");
			while (true)
				stackMenu("list", readInt());
		case 2:
			println("enter the size of the stack:");
			while (true)
				stackMenu("array", readInt());
		case 3:
			println("enter the size of the queue:");
			while (true)
				queueMenu("list", readInt());
		case 4:
			println("enter the size of the queue:");
			while (true)
				queueMenu("array", readInt());
		}

	}
}