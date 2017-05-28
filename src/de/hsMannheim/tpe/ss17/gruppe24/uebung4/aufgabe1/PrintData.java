package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe1;

public class PrintData extends Thread {

	int[] data;

	public PrintData(int[] data) {
		super();
		this.data = data;
	}

	private void printData() {
		for (int current : data) {
			System.out.print(current + " ");
		}
		System.out.println();
	}

	@Override
	public void run() {
		System.out.println("printer started");
		while (true) {
			synchronized (data) {printData();}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
