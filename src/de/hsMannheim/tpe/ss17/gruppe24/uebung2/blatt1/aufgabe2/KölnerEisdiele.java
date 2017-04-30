package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt1.aufgabe2;
import static gdi.MakeItSimple.*;

public class K�lnerEisdiele extends Eisdiele {

	public K�lnerEisdiele(){
		String[] sphagettiSorten = { "Vanille" };
		String[] sphagettiExtras = { "Erdbeerso�e", "Kokosflocken" };

		String[] bananensplitSorten = { "Vanille", "Schokolade", "Erdbeer" };
		String[] bananensplitExtras = { "Ananassyrup", "Schokoladensauce", "Erdbeersyrup", "Nusssplittern",
				"Schlagsahne", "Kirschen" };

		String[] nussbecherSorten = { "Nuss" };
		String[] nussbecherExtras = { "Schokolinsen", "Schokoladensauce", "Krokant" };

		this.eisKarte = new K�lnerEis[] {
				new K�lnerEis("Spaghettieis", 5.0, "Teller", "Spaghettis", sphagettiSorten, sphagettiExtras),
				new K�lnerEis("Bananensplit", 7.5, "Teller", "Kugeln", bananensplitSorten, bananensplitExtras),
				new K�lnerEis("Nussbecher", 4.5, "Glas", "Kugeln", nussbecherSorten, nussbecherExtras) };
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
