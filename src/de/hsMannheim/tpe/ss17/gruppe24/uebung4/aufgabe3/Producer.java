package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe3;

public class Producer extends Thread {

	private RingBuffer buffer;
	private long sleepTime;

	public Producer(RingBuffer buffer, long sleepTime) {
		this.buffer = buffer;
		this.sleepTime = sleepTime;
	}

	public Producer(RingBuffer buffer, long sleepTime, String name) {
		super(name);
		this.buffer = buffer;
		this.sleepTime = sleepTime;
	}

	public void run() {
		try {
			while (!isInterrupted()) {
				buffer.put(new Integer((int)(Math.random() * 1000)));
				Thread.sleep(sleepTime);
			}
		} catch (InterruptedException e) {
			System.out.println(this.getName() + " terminating.");
		}
	}
}
