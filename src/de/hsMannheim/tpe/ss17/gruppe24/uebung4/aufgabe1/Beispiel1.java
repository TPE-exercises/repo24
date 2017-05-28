package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe1;

//Liveness Hazard
//Ein Programm mit mehreren Threads kommt in einen Zustand, in dem es nicht mehr weiter geht.
//Es kann oft nicht vorhergesagt werden, wie lange ein Thread braucht, um zu beenden.
//Beispielprogramm:
//Es wird ein Thread verwendet, um externe Daten zu beschaffen. Mithilfe von isAlive()
//kann abgefragt werden, ob der Thread noch laeuft.
//Dauert es zu lange, kann der Vorgang abgebrochen werden


public class Beispiel1 extends Thread {

	public String data;
	public Beispiel1() {
		super();
		data = null;
	}
	
	@Override
	public void run(){
		//Simuliert das Warten auf eine externe Eingabe
		try {
			Thread.sleep((long)(5000 * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		data = "Hallo!";
		
	}

	public static void main(String[] argv) {
		Beispiel1 thread = new Beispiel1();
		long startTime = System.currentTimeMillis();
		thread.start();
		
		System.out.println("Wartet auf eine Nachricht...");
		while(thread.isAlive()){
			//Es wird nach drei Sekunden abgebrochen, auf eine Datenuebertragung zu warten
			long currentTime = System.currentTimeMillis();
			if(currentTime - startTime > 3000){
				System.out.println("Die Datenuebertragung dauert zu lange... Programm abgebrochen");
				return;
			}
		}
		
		System.out.println("Die empfangene Nachricht ist: " + thread.data);

	}
}
