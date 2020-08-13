package interface_graphique;

import java.util.LinkedList;

import javafx.scene.layout.VBox;
import logique_jeu.Affrontement;
import logique_jeu.Carte;

public class Ligne extends VBox {

	private Borne borne;
	private LinkedList<EmplacementCarte> emplacementCartesJ1;
	private LinkedList<EmplacementCarte> emplacementCartesJ2;

	public Ligne() {

		this.borne = new Borne();
		this.emplacementCartesJ1 = new LinkedList<EmplacementCarte>();
		this.emplacementCartesJ2 = new LinkedList<EmplacementCarte>();

		for (int i = 0; i < 3; i++) {
			this.emplacementCartesJ1.add(new EmplacementCarte());
		}

		for (int i = 0; i < 3; i++) {
			this.emplacementCartesJ2.add(new EmplacementCarte());
		}
	}

	public void dessine() {
		this.setSpacing(10);
		for (EmplacementCarte emplacementCarte : emplacementCartesJ2) {
			this.getChildren().add(emplacementCarte);
		}
		this.getChildren().add(borne);
		for (EmplacementCarte emplacementCarte : emplacementCartesJ1) {
			this.getChildren().add(emplacementCarte);
		}
	}

	public LinkedList<EmplacementCarte> getEmplacementCartesJ1() {
		return this.emplacementCartesJ1;
	}

	public LinkedList<EmplacementCarte> getEmplacementCartesJ2() {
		return this.emplacementCartesJ2;
	}

	public int mettreAJourAffrontements() {

		LinkedList<Carte> cartesJ1 = new LinkedList<Carte>();
		LinkedList<Carte> cartesJ2 = new LinkedList<Carte>();

		for(EmplacementCarte emplacementCarte : emplacementCartesJ1) {
			if(emplacementCarte.getCarteG() != null)
				cartesJ1.add(emplacementCarte.getCarteG().getCarte());
		}

		for(EmplacementCarte emplacementCarte : emplacementCartesJ2) {
			if(emplacementCarte.getCarteG() != null)
				cartesJ2.add(emplacementCarte.getCarteG().getCarte());
		}

		if (cartesJ1.size() == 3 && cartesJ2.size() == 3) {
			Affrontement affrontement = new Affrontement(cartesJ1, cartesJ2);
			if (affrontement.gagnant() == 1) {
				this.borne.changementCouleur(1);
				return 1;
			}
			else if (affrontement.gagnant() == 2){
				this.borne.changementCouleur(2);
				return 2;
			}
			else {
				this.borne.changementCouleur(0);
			}
		}

		return 0;

	}

	public LinkedList<EmplacementCarte> getEmplacementCarteJ2() {
		return this.emplacementCartesJ2;
	}

}
