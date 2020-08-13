package interface_graphique;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pastille extends Circle {

	int joueur;

	public Pastille(int joueur) {
		super(20);
		this.joueur = joueur;
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(3);
	}

	public void allumerPastille() {
		if (this.joueur == 1) {
			this.setFill(Color.GREEN);
		}
		else {
			this.setFill(Color.RED);
		}
	}

	public void eteindrePastille() {
		this.setFill(Color.WHITE);
	}

}
