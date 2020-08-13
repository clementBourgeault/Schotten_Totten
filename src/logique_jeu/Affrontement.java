package logique_jeu;

import java.util.Collections;
import java.util.LinkedList;

public class Affrontement {

	private LinkedList<Carte> cartesJ1;
	private LinkedList<Carte> cartesJ2;

	public Affrontement(LinkedList<Carte> cartesJ1, LinkedList<Carte> cartesJ2) {
		this.cartesJ1 = cartesJ1;
		this.cartesJ2 = cartesJ2;
	}

	public int gagnant() {
		if (getScore(cartesJ1) > getScore(cartesJ2)) {
			return 1;
		}
		else if (getScore(cartesJ1) < getScore(cartesJ2)) {
			return 2;
		}
		else {
			if (somme(cartesJ1) > somme(cartesJ2)) {
				return 1;
			}
			else if (somme(cartesJ1) < somme(cartesJ2)) {
				return 2;
			}
		}
		return 0;
	}

	private int getScore(LinkedList<Carte> cartes) {
		if (estSuiteCouleur(cartes)) {
			return 4;
		}
		else if (estBrelan(cartes)) {
			return 3;
		}
		else if (estCouleur(cartes)) {
			return 2;
		}
		else if (estSuite(cartes)) {
			return 1;
		}
		return 0;
	}

	private boolean estSuiteCouleur(LinkedList<Carte> cartes) {
		return estCouleur(cartes) && estSuite(cartes);
	}

	private boolean estBrelan(LinkedList<Carte> cartes) {
		int valeur = cartes.getFirst().getValeur();
		for (Carte carte : cartes) {
			if (carte.getValeur() != valeur) {
				return false;
			}
		}
		return true;
	}

	private boolean estCouleur(LinkedList<Carte> cartes) {
		Couleur couleur = cartes.getFirst().getCouleur();
		for (Carte carte : cartes) {
			if (carte.getCouleur() != couleur) {
				return false;
			}
		}
		return true;
	}

	private boolean estSuite(LinkedList<Carte> cartes) {
		LinkedList<Integer> listeValeurs = new LinkedList<Integer>();
		for (Carte carte : cartes) {
			listeValeurs.add(carte.getValeur());
		}
		Collections.sort(listeValeurs);
		int ancienneValeur = listeValeurs.getFirst() - 1;
		for (int valeur : listeValeurs) {
			if (valeur != ancienneValeur + 1) {
				return false;
			}
			ancienneValeur++;
		}
		return true;
	}

	private int somme(LinkedList<Carte> cartes) {
		int res = 0;
		for(Carte carte : cartes) {
			res += carte.getValeur();
		}
		return res;
	}

}
