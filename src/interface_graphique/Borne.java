package interface_graphique;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Borne extends Rectangle {

	public Borne() {
		super(60, 40);
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(3);
	}

	public void changementCouleur(int joueur) {
		if (joueur == 1) {
			this.setFill(Color.GREEN);
		}
		else if (joueur == 2){
			this.setFill(Color.RED);
		}
		else {
			this.setFill(Color.GRAY);
		}
	}

}
