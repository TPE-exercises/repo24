package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.println;

public class BerlinerEis extends Eis {

	public BerlinerEis(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras){
		super(name, preis, behaeltnis, art, sorten, extras);
	}
	@Override
	public void vorbereiten() {
		if (this.behaeltnis.equals("Waffel") || this.behaeltnis.equals("Sch�ssel"))
			println("Der Eisverk�ufer nimmt eine " + this.behaeltnis + " in die Hand. ");
		else if (this.behaeltnis.equals("Becher") || this.behaeltnis.equals("Teller"))
			println("Der Eisverk�ufer nimmt einen " + this.behaeltnis + " in die Hand. ");
		else if (this.behaeltnis.equals("Glas"))
			println("Der Eisverk�ufer nimmt ein " + this.behaeltnis + " in die Hand. ");

	}

}
