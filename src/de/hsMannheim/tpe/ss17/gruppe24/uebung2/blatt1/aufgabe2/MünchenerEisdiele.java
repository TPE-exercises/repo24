package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;
import static gdi.MakeItSimple.*;

public class MünchenerEisdiele extends Eisdiele {

	@Override
	public void begruessen() {
		println("Guadn Dog und Wuikomma in da Eisdiele!");

	}

	@Override
	public void kassieren(double preis) {
		println("Des macht dann " + String.format("%.2f", preis) + "biddä."); 

	}

	@Override
	public void verabschieden() {
		println("Auf Wiederseng! Und lossn Sie si ihr Eis schmeckn!");

	}

	@Override
	public void entschuldigen() {
		println("'s tut uns leid, dess Eis städ ned auf da Kartn.");

	}

}
