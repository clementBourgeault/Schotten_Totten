package interface_graphique;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EmplacementCarte extends StackPane {

	private CarteG carteG;
	private Rectangle rectangle;

	public EmplacementCarte(CarteG carteG) {

		this.carteG = carteG;
		rectangle = new Rectangle(60, 90);
		rectangle.setFill(Color.WHITE);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(2);

		this.getChildren().addAll(rectangle, carteG);

	}

	public EmplacementCarte() {

		rectangle = new Rectangle(60, 90);
		rectangle.setFill(Color.WHITE);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(2);

		this.getChildren().add(rectangle);

	}

	public void survolerEmplacement() {
		this.rectangle.setFill(Color.GRAY);
	}

	public void quitterEmplacement() {
		this.rectangle.setFill(Color.WHITE);
	}

	public CarteG getCarteG() {
		return this.carteG;
	}

	public void setCarte (CarteG carteG) {
		this.carteG = carteG;
		this.getChildren().add(carteG);
	}

	public void supprimeCarte() {
		this.carteG = null;
	}

	public boolean estVide() {
		return this.carteG == null;
	}

}