package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe1;

import static gdi.MakeItSimple.*;

public class testEisdiele {
	
	public static void main(String[] argv){
		Eisdiele standardEisdiele = new Eisdiele();
		String[] eisKarte = standardEisdiele.getEisKarte();
		
		print("Eiskarte: ");
		
		for(int i = 0; i < eisKarte.length - 1; i++){
			print(eisKarte[i] + ", ");
		}
		
		println(eisKarte[eisKarte.length - 1] + ".");
		println("Gewünschtes Eis eingeben: ");
	
		standardEisdiele.bestellen(readLine());
	}
	
}
