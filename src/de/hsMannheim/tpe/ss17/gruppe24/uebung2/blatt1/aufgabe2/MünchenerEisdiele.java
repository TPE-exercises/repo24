package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class M�nchenerEisdiele extends Eisdiele {

	public M�nchenerEisdiele() {

		String[] sphagettiSorten = { "Vanille" };
		String[] sphagettiExtras = { "Erdbeerso�e", "Kokosflocken" };

		String[] yoghurtbecherSorten = { "Yoghurt", "Holunder", "Limonen"};
		String[] yoghurtbecherExtras = { "Kiwist�cke", "Limettensyrup"};


		String[] bieneMayaSorten = { "Zitronen" };
		String[] bieneMayaExtras = { "Sahne", "Schokolinsen", "Schokosauce" };

		this.eisKarte = new M�nchenerEis[] {
				new M�nchenerEis("Spaghettieis", 5.0, "Teller", "Spaghettis", sphagettiSorten, sphagettiExtras),
				new M�nchenerEis("Yoghurtbecher", 8.5, "Becher", "Kugeln", yoghurtbecherSorten, yoghurtbecherExtras),
				new M�nchenerEis("Biene Maya", 4, "Teller", "Kugeln", bieneMayaSorten, bieneMayaExtras) };
	}

	@Override
	public void begruessen() {
		println("Guadn Dog und Wuikomma in da Eisdiele!");

	}

	@Override
	public void kassieren(double preis) {
		println("Des macht dann " + String.format("%.2f", preis) + " Euro bidd�.");

	}

	@Override
	public void verabschieden() {
		println("Auf Wiederseng! Und lossn Sie si ihr Eis schmeckn!");

	}

	@Override
	public void entschuldigen() {
		println("'s tut uns leid, dess Eis st�d ned auf da Kartn.");

	}

}
