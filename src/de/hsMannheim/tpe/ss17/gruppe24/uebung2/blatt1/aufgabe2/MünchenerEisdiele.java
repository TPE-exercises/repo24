package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class MünchenerEisdiele extends Eisdiele {

	public MünchenerEisdiele() {

		String[] sphagettiSorten = { "Vanille" };
		String[] sphagettiExtras = { "Erdbeersoße", "Kokosflocken" };

		String[] yoghurtbecherSorten = { "Yoghurt", "Holunder", "Limonen"};
		String[] yoghurtbecherExtras = { "Kiwistücke", "Limettensyrup"};


		String[] bieneMayaSorten = { "Zitronen" };
		String[] bieneMayaExtras = { "Sahne", "Schokolinsen", "Schokosauce" };

		this.eisKarte = new MünchenerEis[] {
				new MünchenerEis("Spaghettieis", 5.0, "Teller", "Spaghettis", sphagettiSorten, sphagettiExtras),
				new MünchenerEis("Yoghurtbecher", 8.5, "Becher", "Kugeln", yoghurtbecherSorten, yoghurtbecherExtras),
				new MünchenerEis("Biene Maya", 4, "Teller", "Kugeln", bieneMayaSorten, bieneMayaExtras) };
	}

	@Override
	public void begruessen() {
		println("Guadn Dog und Wuikomma in da Eisdiele!");

	}

	@Override
	public void kassieren(double preis) {
		println("Des macht dann " + String.format("%.2f", preis) + " Euro biddä.");

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
