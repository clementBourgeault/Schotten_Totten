package logique_jeu;

import java.util.LinkedList;

import interface_graphique.Ligne;
import interface_graphique.MainG;

public abstract class IA {

	protected MainG mainIA;
	protected LinkedList<Ligne> lignes;

	public IA(MainG mainIA, LinkedList<Ligne> lignes) {
		this.mainIA = mainIA;
		this.lignes = lignes;
	}

	public abstract void jouerCarte();

}
