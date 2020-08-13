package logique_jeu;

public class Carte {

	private int valeur;
	private Couleur couleur;

	public Carte(int valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}

	public String toString() {
		return this.couleur + " " + this.valeur;
	}

	public int getValeur() {
		return this.valeur;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

}
