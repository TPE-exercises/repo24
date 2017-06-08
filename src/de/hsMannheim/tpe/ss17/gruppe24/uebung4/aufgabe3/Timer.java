package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe3;

public class Timer extends Thread {

	private long runTime;
	private Thread[] threads;

	public Timer(int runTime, Thread[] threads) {
		this.runTime = runTime * 60 * 1000;
		this.threads = threads;
	}

	public void run() {
		runTime += System.currentTimeMillis();
		while (runTime - System.currentTimeMillis() >= 0){
			// wait
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].interrupt();
		}

	}

}
