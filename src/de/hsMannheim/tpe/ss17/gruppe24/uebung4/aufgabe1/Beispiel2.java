package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe1;


//Safety Hazards: programm funktioniert durch Anwesenheit von mehreren Threads nicht mehr korrekt.
//Wenn zwei threads mit den selben Daten arbeiten, muessen diese Zugriffe abgestimmt werden.
//Das soll durch eine Synchronisation erreicht werden.
//Beispielprogramm:
//Zwei Threads greifen ohne Synchronisation auf eine Variable zu.
//Das ergebnis ist anders als man erwarten könnte ungleich 100000*2 ,
// da es zu einer Racecondition kommt.

public class Beispiel2 implements Runnable {

	public int counter = 0;
	
	public void run(){
		for(int i = 0; i < 100000; i++){
			counter++;
		}
	}
	
	public static void main(String[] argv){
		Beispiel2 bsp = new Beispiel2();
		
		Thread th1 = new Thread(bsp);
		Thread th2 = new Thread(bsp);
		

		try {		
			th1.start();
			th2.start();
		
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(bsp.counter);
		
	}
}


