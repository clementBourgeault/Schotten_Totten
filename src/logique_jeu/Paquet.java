package logique_jeu;

import java.util.Collections;
import java.util.LinkedList;

public class Paquet {

	private LinkedList<Carte> cartes;
	private int position;

	public Paquet() {

		cartes = new LinkedList<Carte>();
		position = 0;

		for (int i = 1; i <= 9; i++) {
			cartes.add(new Carte(i, Couleur.BLEU));
		}
		for (int i = 1; i <= 9; i++) {
			cartes.add(new Carte(i, Couleur.ROUGE));
		}
		for (int i = 1; i <= 9; i++) {
			cartes.add(new Carte(i, Couleur.VERT));
		}
		for (int i = 1; i <= 9; i++) {
			cartes.add(new Carte(i, Couleur.JAUNE));
		}
		for (int i = 1; i <= 9; i++) {
			cartes.add(new Carte(i, Couleur.MARRON));
		}
		for (int i = 1; i <= 9; i++) {
			cartes.add(new Carte(i, Couleur.VIOLET));
		}
	}

	public void melanger() {
		Collections.shuffle(this.cartes);
	}

	public Carte piocher() {
		position++;
		return cartes.get(position - 1);
	}

	public boolean estVide() {
		return this.position == 54;
	}

}
