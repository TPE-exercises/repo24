package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe1;

//Performance Hazard
//Programm funktioniert korrekt, die Performance ist aber trotz mehrerer Threads schlecht
//
//Beispiel: Eine Aufgabe auf mehrere Threads aufteilen, die effektiver 
//in einem Thread durchgefuert werden koennte. 
//Die Performance wird durch Multithreading nicht verbessert, da in diesem Beispiel
//die Threads sowieso synchronisiert werden muessen.

public class Beispiel3 extends Thread {

	private int value;
	private int[] data;
	private String operation;

	public Beispiel3(int[] data, int value, String operation) {
		this.data = data;
		this.operation = operation;
		this.value = value;
	}

	public void doSomething() {
		if (operation.equals("add")) {
			for (int i = 0; i < data.length; i++)
				data[i] += value;
		}

		if (operation.equals("subtract")) {
			for (int i = 0; i < data.length; i++)
				data[i] -= value;
		}
	}

	public void printArray() {
		for (int current : data) {
			System.out.print(current + " ");
		}
		System.out.println();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (data) {
				doSomething();
				printArray();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] argv) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Beispiel3 thread1 = new Beispiel3(data, 5, "add");
		Beispiel3 thread2 = new Beispiel3(data, 4, "subtract");

		thread1.start();
		thread2.start();
	}

}
