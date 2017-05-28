package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe1;

public class GetRandomInts extends Thread {

	int[] data;


	public GetRandomInts(int[] data) {
		this.data = data;
	}
	
	public synchronized void getRandoms(int[] data){
		for(int i = 0; i < data.length; i++){
			data[i] = (int) (Math.random() * 100);
		}
	}

	@Override
	public void run() {
		
		System.out.println("GetRandomInts started");
		while (true) {
			synchronized (data) {getRandoms(data);}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
