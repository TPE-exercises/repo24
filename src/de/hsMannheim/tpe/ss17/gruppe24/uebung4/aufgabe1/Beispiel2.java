package de.hsMannheim.tpe.ss17.gruppe24.uebung4.aufgabe1;


//Safety Hazards: programm funktioniert durch Anwesenheit von mehreren Threads nicht mehr korrekt.
//Wenn zwei threads mit den selben Daten arbeiten, muessen diese Zugriffe abgestimmt werden.
//Das soll durch Synchronisation erreicht.
//Beispielprogramm:
//Ein thread lädt Daten in ein Array und der andere druckt sie aus. 
//Alle Methoden, die auf das Array zugreifen, werden in einem synchronisierten Block ausgeführt.
//Dadurch wird das Array nur gedruckt, wenn nicht gerade darauf geschrieben wird.


public class Beispiel2 {

	public static void main(String[] argv){
		
		int[] data = new int[10];
		System.out.println("Program started");
		GetRandomInts rng = new GetRandomInts(data);
		PrintData printer = new PrintData(data);
		
		rng.start();
		printer.start();
		
		
	}
}


