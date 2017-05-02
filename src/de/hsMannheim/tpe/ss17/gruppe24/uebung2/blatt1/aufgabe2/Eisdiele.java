package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;


public abstract class Eisdiele {

	protected Eis[] eisKarte;

/**
 * @return all icecream saved in a String array
 */
	public final String[] getEisKarte() {
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
	public final void bestellen(String eisName) {
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
	 * should print the greeting to the customer
	 */
	public abstract void begruessen();

	/**
	 * should print the icecreamseller announcing the price of the icecream
	 * @param preis price of the icecream
	 */
	public abstract void kassieren(double preis);

	/**
	 * print the farewell wish
	 */
	public abstract void verabschieden();

	/**
	 * print the apology if the desired icecream is not on the menu
	 */
	public abstract void entschuldigen();
}
