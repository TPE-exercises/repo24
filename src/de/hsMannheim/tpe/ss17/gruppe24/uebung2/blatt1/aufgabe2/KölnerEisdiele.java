package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;
import static gdi.MakeItSimple.*;

public class KölnerEisdiele extends Eisdiele {

	public KölnerEisdiele(){
		String[] sphagettiSorten = { "Vanille" };
		String[] sphagettiExtras = { "Erdbeersoße", "Kokosflocken" };

		String[] melonenmixSorten = { "Vanille", "Melonen"};
		String[] melonenmixExtras = { "Melonenstücken", "Kiwi", "Himbeeren" };

		String[] tiramisubecherSorten = { "Tiramisu", "Vanille" };
		String[] tiramisubecherExtras = { "Sahne, Kakaopulver, Marsalalikör, Löffelbiskuits" };

		this.eisKarte = new KölnerEis[] {
				new KölnerEis("Spaghettieis", 5.0, "Teller", "Spaghettis", sphagettiSorten, sphagettiExtras),
				new KölnerEis("Melonenmix", 7, "Teller", "Kugeln", melonenmixSorten, melonenmixExtras),
				new KölnerEis("Tiramisubecher", 8, "Becher", "Kugeln", tiramisubecherSorten, tiramisubecherExtras) };
	}
	
	@Override
	public void begruessen() {
		println("Jode Dach un Jepeffe end'r Eisdiele!");
	}

	@Override
	public void kassieren(double preis) {
		println("Dat määt dann " + String.format("%.2f", preis) + " Euro bitte.");
	}

	@Override
	public void verabschieden() {
		println("Op Widdersin! Un loße Se sich ehr Ies schmecke!");
	}

	@Override
	public void entschuldigen() {
		println("Et deitm'r leid, dieses Ies steiht nit opd'r Kaat.");
	}

}
