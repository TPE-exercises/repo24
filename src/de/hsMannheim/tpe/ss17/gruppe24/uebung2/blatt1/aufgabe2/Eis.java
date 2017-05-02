package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public abstract class Eis {

	private String name;
	private double preis;
	private String art;
	private String[] sorten;
	private String[] extras;
	protected String behaeltnis;
	

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

	public final String getName() {
		return this.name;
	}

	public final double getPreis(){
		return this.preis;
	}


	public final String getBehaeltnis(){
		return this.behaeltnis;
	}
	
	/**
	 * Print a sentence that explains how the correct "Behältnis" is chosen
	 */
	public abstract void vorbereiten();

	/**
	 * print how the icecream is made
	 */
	public final void fuellen() {
		if (this.sorten.length == 1) {

			if (this.art.equals("Spaghettis")) {
				println("Daraufhin füllt er eine Portion " + this.sorten[0] + "spaghettieis ein.");
			}

			if (this.art.equals("Kugel")) {
				println("Daraufhin füllt er eine Kugel " + this.sorten[0] + "eis ein.");
			}
		}
		if (this.sorten.length > 1) {


				print("Daraufhin füllt er nacheinander eine Kugel ");
				for (int i = 0; i < this.sorten.length - 1; i++) {
					print(this.sorten[i] + "eis");
					if (i < this.sorten.length - 2) {
						print(", ");
					}
				}

				println(" und " + this.sorten[this.sorten.length - 1] + "eis ein.");
			
		}
	}

	/**
	 * print how the icecream is decorated
	 */
	public final void dekorieren() {
		if(this.extras.length == 1){
			println("Dann verfeinert er das Eis mit " + this.extras[0] + ".");
		}
		
		if (this.extras.length > 1) {
			print("Dann verfeinert er das Eis nacheinander mit ");
			for (int i = 0; i < this.extras.length - 1; i++) {
				print(this.extras[i]);
				if(i < this.extras.length - 2){
					print(", ");
				}
			}

			println(" und " + this.extras[this.extras.length - 1]+ ".");

		}
	}

}
