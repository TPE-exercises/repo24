package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;
import static gdi.MakeItSimple.*;

public class BerlinerEisdiele extends Eisdiele {

	public BerlinerEisdiele(){
		String[] pfirsichbecherSorten = { "Vanille", "Pfirsich", "Zitronen" };
		String[] pfirsichbecherExtras = { "Orangenlikör", "Pfirsichstücken", "Mandelkrokant"};

		String[] bananensplitSorten = { "Vanille", "Schokolade", "Erdbeer" };
		String[] bananensplitExtras = { "Ananassyrup", "Schokoladensauce", "Erdbeersyrup", "Nusssplittern",
				"Schlagsahne", "Kirschen" };

		String[] suedseeeisSorten = { "Zitronen", "Orangen", "Kokos" };
		String[] suedseeeisExtras = { "Sahne", "Kokosmilch", "Zuckersträuseln" };

		this.eisKarte = new BerlinerEis[] {
				new BerlinerEis("Pfirsicheisbecher", 6.0, "Becher", "Kugeln", pfirsichbecherSorten, pfirsichbecherExtras),
				new BerlinerEis("Bananensplit", 7.5, "Teller", "Kugeln", bananensplitSorten, bananensplitExtras),
				new BerlinerEis("Südseeeis", 9, "Glas", "Kugeln", suedseeeisSorten, suedseeeisExtras) };
	}
	
	
	@Override
	public void begruessen() {
		println("Tach och!");

	}

	@Override
	public void kassieren(double preis) {
		println("Dit macht denn " + String.format("%.2f", preis) + " Euro bitte." );
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
