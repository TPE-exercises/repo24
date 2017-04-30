package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.println;

public class MünchenerEis extends Eis {

	@Override
	public void vorbereiten() {
		if (this.behaeltnis.equals("BierteigWaffel") || this.behaeltnis.equals("Schüssel"))
			println("Der Eisverkäufer nimmt eine " + this.behaeltnis + " in die Hand. ");
		else if (this.behaeltnis.equals("Becher") || this.behaeltnis.equals("Teller"))
			println("Der Eisverkäufer nimmt einen " + this.behaeltnis + " in die Hand. ");
		else if (this.behaeltnis.equals("Glas"))
			println("Der Eisverkäufer nimmt ein " + this.behaeltnis + " in die Hand. ");

	}

}
