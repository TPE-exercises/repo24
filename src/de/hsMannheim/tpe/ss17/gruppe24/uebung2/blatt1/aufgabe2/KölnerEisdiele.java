package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;
import static gdi.MakeItSimple.*;

public class K�lnerEisdiele extends Eisdiele {

	public K�lnerEisdiele(){
		String[] sphagettiSorten = { "Vanille" };
		String[] sphagettiExtras = { "Erdbeerso�e", "Kokosflocken" };

		String[] melonenmixSorten = { "Vanille", "Melonen"};
		String[] melonenmixExtras = { "Melonenst�cken", "Kiwi", "Himbeeren" };

		String[] tiramisubecherSorten = { "Tiramisu", "Vanille" };
		String[] tiramisubecherExtras = { "Sahne, Kakaopulver, Marsalalik�r, L�ffelbiskuits" };

		this.eisKarte = new K�lnerEis[] {
				new K�lnerEis("Spaghettieis", 5.0, "Teller", "Spaghettis", sphagettiSorten, sphagettiExtras),
				new K�lnerEis("Melonenmix", 7, "Teller", "Kugeln", melonenmixSorten, melonenmixExtras),
				new K�lnerEis("Tiramisubecher", 8, "Becher", "Kugeln", tiramisubecherSorten, tiramisubecherExtras) };
	}
	
	@Override
	public void begruessen() {
		println("Jode Dach un Jepeffe end'r Eisdiele!");
	}

	@Override
	public void kassieren(double preis) {
		println("Dat m��t dann " + String.format("%.2f", preis) + " Euro bitte.");
	}

	@Override
	public void verabschieden() {
		println("Op Widdersin! Un lo�e Se sich ehr Ies schmecke!");
	}

	@Override
	public void entschuldigen() {
		println("Et deitm'r leid, dieses Ies steiht nit opd'r Kaat.");
	}

}
