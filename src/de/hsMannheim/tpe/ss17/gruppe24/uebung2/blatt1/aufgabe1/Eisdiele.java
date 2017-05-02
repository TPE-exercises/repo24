package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe1;

import static gdi.MakeItSimple.*;

public class Eisdiele {

	private Eis[] eisKarte;

	public Eisdiele() {
		String[] sphagettiSorten = { "Vanille" };
		String[] sphagettiExtras = { "Erdbeersoﬂe", "Kokosflocken" };

		String[] bananensplitSorten = { "Vanille", "Schokoladen", "Erdbeer" };
		String[] bananensplitExtras = { "Ananassyrup", "Schokoladensauce", "Erdbeersyrup", "Nusssplittern",
				"Schlagsahne", "Kirschen" };

		String[] nussbecherSorten = { "Nuss" };
		String[] nussbecherExtras = { "Schokolinsen", "Schokoladensauce", "Krokant" };

		this.eisKarte = new Eis[] {
				new Eis("Spaghettieis", 5.0, "Teller", "Spaghettis", sphagettiSorten, sphagettiExtras),
				new Eis("Bananensplit", 7.5, "Teller", "Kugeln", bananensplitSorten, bananensplitExtras),
				new Eis("Nussbecher", 4.5, "Glas", "Kugeln", nussbecherSorten, nussbecherExtras) };
	}


	/**
	 * @return all icecream saved in a String array
	 */
	public String[] getEisKarte() {
		String[] eisKarteString = new String[this.eisKarte.length];
		for(int i = 0; i < eisKarteString.length; i++){
			eisKarteString[i] = this.eisKarte[i].getName();
		}
		return eisKarteString;
	}

	/**
	 * Prints out all the interaction with the "Eisdiele"
	 * @param eisName the icecream that was ordered
	 */
	public void bestellen(String eisName) {
		begruessen();

		int currentEis = 0;
		while (currentEis < this.eisKarte.length && !this.eisKarte[currentEis].getName().equals(eisName)) {
			currentEis++;
		}

		if (currentEis >= this.eisKarte.length) {
			entschuldigen();
			return;
		}

		Eis bestelltesEis = eisKarte[currentEis];

		bestelltesEis.vorbereiten();
		bestelltesEis.fuellen();
		bestelltesEis.dekorieren();

		kassieren(bestelltesEis.getPreis());
		verabschieden();

	}

	/**
	 * print the greeting to the customer
	 */
	void begruessen() {

		println("Guten Tag und Willkommen in der Eisdiele!");

	}

	/**
	 * print the icecreamseller announcing the price of the icecream
	 * @param preis price of the icecream
	 */
	void kassieren(double preis) {
		println("Das macht dann " + String.format("%.2f", preis) + " Euro bitte.");
	}

	/**
	 * print the farewell wish
	 */
	void verabschieden() {
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}

	/**
	 * print the apology if the desired icecream is not on the menu
	 */
	void entschuldigen() {
		println("Es tut uns leid, dieses Eis steht nicht auf der Karte.");
	}
}
