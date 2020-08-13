package interface_graphique;

import java.util.LinkedList;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logique_jeu.Paquet;

public class MainG extends VBox{

	private LinkedList<CarteG> cartesG;
	private LinkedList<EmplacementCarte> emplacementCartes;
	private CarteG carteSelectionnee;
	private Paquet paquet;
	private EmplacementCarte emplacementCarteVide;
	private Pastille pastille;
	private String nomJoueur;

	public MainG(Paquet paquet, String nomJoueur, int ordre) {

		this.nomJoueur = nomJoueur;
		Text textJoueur = new Text(this.nomJoueur);
		this.pastille = new Pastille(ordre);

		HBox hBox = new HBox(8);

		cartesG = new LinkedList<CarteG>();

		for(int i = 0; i < 6; i++) {
			cartesG.add(new CarteG(paquet.piocher()));
		}

		this.emplacementCartes = new LinkedList<EmplacementCarte>();

		this.paquet = paquet;
		for (CarteG carteG : cartesG) {
			this.emplacementCartes.add(new EmplacementCarte(carteG));
		}

		if (ordre == 1) {
			this.pastille.allumerPastille();
			hBox.getChildren().addAll(pastille, textJoueur);
			textJoueur.setFill(Color.GREEN);
			textJoueur.setStyle("-fx-font: 30 arial;");
			this.getChildren().addAll(emplacementCartes);
			this.getChildren().add(hBox);
			selectionnerCarte();
		}
		else {
			hBox.getChildren().addAll(textJoueur, pastille);
			textJoueur.setFill(Color.RED);
			textJoueur.setStyle("-fx-font: 30 arial;");
			this.getChildren().add(hBox);
			this.getChildren().addAll(emplacementCartes);
		}

		this.setSpacing(10);

	}

	public void dessine() {
		for (EmplacementCarte emplacementCarte : this.emplacementCartes) {
			if(!emplacementCarte.estVide())
				emplacementCarte.getCarteG().dessine();
		}
	}

	private void selectionnerCarte() {
		for (EmplacementCarte emplacementCarte : this.emplacementCartes) {
			emplacementCarte.setOnMouseEntered(e -> {
				if (this.carteSelectionnee == null && !emplacementCarte.estVide())
					emplacementCarte.survolerEmplacement();
			});
			emplacementCarte.setOnMouseExited(e -> {
				if (this.carteSelectionnee == null)
					emplacementCarte.quitterEmplacement();
			});
			emplacementCarte.setOnMouseClicked(e -> {
				if (!emplacementCarte.estVide()) {
					toutDeselectionner();
					emplacementCarte.survolerEmplacement();
					this.carteSelectionnee = emplacementCarte.getCarteG();
					this.emplacementCarteVide = emplacementCarte;
				}
			});
		}
	}

	public CarteG getCarteSelectionne() {
		return this.carteSelectionnee;
	}

	public void supprimerCarteSelectionne() {
		this.carteSelectionnee = null;
	}

	public void toutDeselectionner() {
		for(EmplacementCarte emplacementC : this.emplacementCartes) {
			emplacementC.quitterEmplacement();
		}
	}

	public void piocher() {
		if (!this.paquet.estVide())
			this.emplacementCarteVide.setCarte(new CarteG(paquet.piocher()));
		else {
			this.emplacementCarteVide.supprimeCarte();
		}
		dessine();
	}

	public CarteG getCarteAleatoire() {
		int numeroCarte = (int) (Math.random()*6);
		while(this.emplacementCartes.get(numeroCarte).estVide()) {
			numeroCarte = (int) (Math.random()*6);
		}
		this.emplacementCarteVide = this.emplacementCartes.get(numeroCarte);
		return this.emplacementCartes.get(numeroCarte).getCarteG();
	}

	public void activerPastille() {
		this.pastille.allumerPastille();
	}

	public void desactiverPastille() {
		this.pastille.eteindrePastille();
	}

	public String getNomJoueur() {
		return this.nomJoueur;
	}

	public LinkedList<EmplacementCarte> getEmplacementCartes() {
		return this.emplacementCartes;
	}

	public void cacherMain() {
		for(EmplacementCarte emplacementCarte : this.emplacementCartes) {
			if(emplacementCarte.getCarteG() != null)
				emplacementCarte.getCarteG().cacherCarte();
		}
	}


}
