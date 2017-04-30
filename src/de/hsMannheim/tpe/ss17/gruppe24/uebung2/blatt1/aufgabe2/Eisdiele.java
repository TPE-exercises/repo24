package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;


public abstract class Eisdiele {

	protected Eis[] eisKarte;


	public final String[] getEisKarte() {
		String[] eisKarteString = new String[this.eisKarte.length];
		for(int i = 0; i < eisKarteString.length; i++){
			eisKarteString[i] = this.eisKarte[i].getName();
		}
		return eisKarteString;
	}

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

	public abstract void begruessen();

	public abstract void kassieren(double preis);

	public abstract void verabschieden();

	public abstract void entschuldigen();
}
