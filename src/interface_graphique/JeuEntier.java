package interface_graphique;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import logique_jeu.Paquet;

public class JeuEntier extends BorderPane {

	private MainG mainJ1;
	private MainG mainJ2;
	private Plateau plateau;

	public JeuEntier() {

		Paquet paquet = new Paquet();
		paquet.melanger();

		this.mainJ1 = new MainG(paquet, "Clément", 1);
		this.mainJ2 = new MainG(paquet, "Ordinateur", 2);

		this.plateau = new Plateau(mainJ1, mainJ2);

		this.setLeft(mainJ1);
		BorderPane.setMargin(mainJ1, new Insets(0, 0, 0, 80));
		mainJ1.setAlignment(Pos.CENTER);
		this.setCenter(plateau);
		plateau.setAlignment(Pos.BOTTOM_CENTER);
		this.setRight(mainJ2);
		BorderPane.setMargin(mainJ2, new Insets(0, 80, 0, 0));
		mainJ2.setAlignment(Pos.CENTER);

	}

	public void dessine() {

		this.mainJ1.dessine();
		this.plateau.dessine();
		this.mainJ2.dessine();

	}

}
