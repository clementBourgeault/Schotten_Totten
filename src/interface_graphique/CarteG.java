package interface_graphique;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import logique_jeu.Carte;

public class CarteG extends StackPane {

	private Carte carte;
	private Rectangle rectangle;

	public CarteG(Carte carte) {
		this.carte = carte;
		rectangle = new Rectangle(50, 80);
		rectangle.setFill(this.carte.getCouleur().getColor());
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(3);

		Text texte = new Text(Integer.toString(this.carte.getValeur()));
		texte.setStyle("-fx-font: 30 arial;");

		this.getChildren().addAll(rectangle, texte);
	}

	public void dessine() {



	}

	public Carte getCarte() {
		return this.carte;
	}

	public void cacherCarte() {
		rectangle.setFill(Color.BLACK);
	}

	public void afficherCarte() {
		rectangle.setFill(this.carte.getCouleur().getColor());
	}

}
