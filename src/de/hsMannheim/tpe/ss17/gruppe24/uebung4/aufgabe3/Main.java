package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe3;

public class Main {

	public static void main(String[] args){
		RingBuffer buffer = new RingBuffer(50);
		Thread[] threads = new Thread[5];
		threads[0] = new Producer(buffer, 1000, "Producer1");
		threads[0].setDaemon(true);
		threads[1] = new Producer(buffer, 800, "Producer2");
		threads[1].setDaemon(true);
		threads[2] = new Producer(buffer, 500, "Producer3");
		threads[2].setDaemon(true);
		threads[3] = new Consumer(buffer, 1000, "Consumer1");
		threads[3].setDaemon(true);
		threads[4] = new Consumer(buffer, 500, "Consumer2");
		threads[4].setDaemon(true);
		
		
		
		Timer timer = new Timer(1, threads);
		timer.start();
		for(int i = 0; i < threads.length; i++){
			threads[i].start();
		}

	}
}
