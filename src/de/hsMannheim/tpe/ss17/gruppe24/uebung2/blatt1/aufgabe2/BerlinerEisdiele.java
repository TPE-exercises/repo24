package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;
import static gdi.MakeItSimple.*;

public class BerlinerEisdiele extends Eisdiele {

	@Override
	public void begruessen() {
		println("Tach och!");

	}

	@Override
	public void kassieren(double preis) {
		println("Dit macht denn " + String.format("%.2f", preis) + "bitte." );
	}

	@Override
	public void verabschieden() {
		println("Mach et jut!");

	}

	@Override
	public void entschuldigen() {
		println("Pass ma uff, dieses Eis jibt es leider nich.");

	}

}
