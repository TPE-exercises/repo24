package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe3;

public class Consumer extends Thread {
	private RingBuffer buffer;
	private long sleepTime;

	public Consumer(RingBuffer buffer, long sleepTime) {
		this.buffer = buffer;
		this.sleepTime = sleepTime;
	}

	public Consumer(RingBuffer buffer, long sleepTime, String name) {
		super(name);
		this.buffer = buffer;
		this.sleepTime = sleepTime;
	}

	public void run() {

		try {
			while (!isInterrupted()) {
				System.out.println(this.getName() + " delivered " + buffer.get());
				Thread.sleep(sleepTime);
			}
		} catch (InterruptedException e) {

			System.out.println(this.getName() + " terminating.");

		}
	}
}
