package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class testEisdiele2 {

	
	public static void makemenu(){
		
	}
	
	public static void main(String[] args) {
		Eisdiele k�lnerEisdiele = new K�lnerEisdiele();
		Eisdiele berlinerEisdiele = new BerlinerEisdiele();
		Eisdiele m�nchenerEisdiele = new M�nchenerEisdiele();



		while (true) {
			println("Zu welcher Eisdiele m�chten Sie gehen?");
			println("1: K�lner Eisdiele");
			println("2: Berliner Eisdiele");
			println("3: M�nchener Eisdiele");
			
			int eingabe = readInt();
			readLine();
			String[] eisKarte = null;

			switch (eingabe) {

			case 1:
				eisKarte = k�lnerEisdiele.getEisKarte();
				print("Eiskarte: ");

				for (int i = 0; i < eisKarte.length - 1; i++) {
					print(eisKarte[i] + ", ");
				}
				println(eisKarte[eisKarte.length - 1] + ".");
				println("Gew�nschtes Eis eingeben: ");

				k�lnerEisdiele.bestellen(readLine());
				break;
			case 2:
				eisKarte = berlinerEisdiele.getEisKarte();
				print("Eiskarte: ");

				for (int i = 0; i < eisKarte.length - 1; i++) {
					print(eisKarte[i] + ", ");
				}
				println(eisKarte[eisKarte.length - 1] + ".");
				println("Gew�nschtes Eis eingeben: ");

				berlinerEisdiele.bestellen(readLine());
				break;
			case 3:
				eisKarte = m�nchenerEisdiele.getEisKarte();
				print("Eiskarte: ");

				for (int i = 0; i < eisKarte.length - 1; i++) {
					print(eisKarte[i] + ", ");
				}
				println(eisKarte[eisKarte.length - 1] + ".");
				println("Gew�nschtes Eis eingeben: ");

				m�nchenerEisdiele.bestellen(readLine());
				break;
			}

		}
	}
}
