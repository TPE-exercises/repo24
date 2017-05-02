package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class testEisdiele2 {

	
	public static void makemenu(){
		
	}
	
	public static void main(String[] args) {
		Eisdiele kölnerEisdiele = new KölnerEisdiele();
		Eisdiele berlinerEisdiele = new BerlinerEisdiele();
		Eisdiele münchenerEisdiele = new MünchenerEisdiele();



		while (true) {
			println("Zu welcher Eisdiele möchten Sie gehen?");
			println("1: Kölner Eisdiele");
			println("2: Berliner Eisdiele");
			println("3: Münchener Eisdiele");
			
			int eingabe = readInt();
			readLine();
			String[] eisKarte = null;

			switch (eingabe) {

			case 1:
				eisKarte = kölnerEisdiele.getEisKarte();
				print("Eiskarte: ");

				for (int i = 0; i < eisKarte.length - 1; i++) {
					print(eisKarte[i] + ", ");
				}
				println(eisKarte[eisKarte.length - 1] + ".");
				println("Gewünschtes Eis eingeben: ");

				kölnerEisdiele.bestellen(readLine());
				break;
			case 2:
				eisKarte = berlinerEisdiele.getEisKarte();
				print("Eiskarte: ");

				for (int i = 0; i < eisKarte.length - 1; i++) {
					print(eisKarte[i] + ", ");
				}
				println(eisKarte[eisKarte.length - 1] + ".");
				println("Gewünschtes Eis eingeben: ");

				berlinerEisdiele.bestellen(readLine());
				break;
			case 3:
				eisKarte = münchenerEisdiele.getEisKarte();
				print("Eiskarte: ");

				for (int i = 0; i < eisKarte.length - 1; i++) {
					print(eisKarte[i] + ", ");
				}
				println(eisKarte[eisKarte.length - 1] + ".");
				println("Gewünschtes Eis eingeben: ");

				münchenerEisdiele.bestellen(readLine());
				break;
			}

		}
	}
}
