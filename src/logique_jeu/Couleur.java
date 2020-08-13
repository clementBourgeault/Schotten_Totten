package logique_jeu;

import javafx.scene.paint.Color;

public enum Couleur {

	BLEU(0),
	ROUGE(1),
	VERT(2),
	JAUNE(3),
	MARRON(4),
	VIOLET(5);

	public final static Color[] COLOR = {
			Color.BLUE,
			Color.RED,
			Color.GREEN,
			Color.YELLOW,
			Color.BROWN,
			Color.PURPLE
	};

	public final int couleur;

	private Couleur(int val) {
		couleur = val;
	}

	public Color getColor() {
		return COLOR[couleur];
	}

}
