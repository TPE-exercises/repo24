package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe1;

import static gdi.MakeItSimple.*;

public class Eis {

	private String name;
	private double preis;
	protected String behaeltnis;
	private String art;
	private String[] sorten;
	private String[] extras;

	public Eis() {
		super();
	}

	public Eis(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		super();
		this.name = name;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = sorten;
		this.extras = extras;
	}

	public String getName() {
		return this.name;
	}

	public double getPreis() {
		return this.preis;
	}

	public void vorbereiten() {
		if (this.behaeltnis.equals("Waffel") || this.behaeltnis.equals("Schüssel"))
			println("Der Eisverkäufer nimmt eine " + this.behaeltnis + " in die Hand. ");
		else if (this.behaeltnis.equals("Becher") || this.behaeltnis.equals("Teller"))
			println("Der Eisverkäufer nimmt einen " + this.behaeltnis + " in die Hand. ");
		else if (this.behaeltnis.equals("Glas"))
			println("Der Eisverkäufer nimmt ein " + this.behaeltnis + " in die Hand. ");
	}

	public void fuellen() {
		if (this.sorten.length == 1) {

			if (this.art.equals("Spaghettis")) {
				println("Daraufhin füllt er eine Portion " + this.sorten[0] + "spaghettieis ein.");
			}

			if (this.art.equals("Kugel")) {
				println("Daraufhin füllt er eine Kugel " + this.sorten[0] + "eis ein.");
			}
		}
		if (this.sorten.length > 1) {

			if (this.art.equals("Kugel")) {
				print("Daraufhin füllt er nacheinander eine Kugel ");
				for (int i = 0; i < this.sorten.length - 1; i++) {
					print(this.sorten[i] + "eis");
					if (i < this.extras.length - 2) {
						print(", ");
					}

				}

				println("und " + this.sorten[this.sorten.length - 1] + "eis ein.");
			}
		}
	}

	public void dekorieren() {
		if (this.extras.length == 1) {
			println("Dann verfeinert er das Eis mit " + this.extras[0] + ".");
		}

		if (this.extras.length > 1) {
			print("Dann verfeinert er das Eis nacheinander mit ");
			for (int i = 0; i < this.extras.length - 1; i++) {
				print(this.extras[i]);
				if (i < this.extras.length - 2) {
					print(", ");
				}
			}

			println(" und " + this.extras[this.extras.length - 1] + ".");

		}
	}

}
