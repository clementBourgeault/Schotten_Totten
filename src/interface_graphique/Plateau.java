package interface_graphique;

import java.util.LinkedList;

import javafx.scene.layout.HBox;
import logique_jeu.IA;
import logique_jeu.IAAleatoire;

public class Plateau extends HBox {

	private LinkedList<Ligne> lignes;
	private MainG mainJoueur;
	private MainG mainIA;
	private IA ia;

	public Plateau(MainG mainJoueur, MainG mainIA) {
		this.mainJoueur = mainJoueur;

		this.mainIA = mainIA;
		this.mainIA.cacherMain();

		this.lignes = new LinkedList<Ligne>();

		this.ia = new IAAleatoire(mainIA, lignes);

		for (int i = 0; i < 9; i++) {
			this.lignes.add(new Ligne());
		}
		for (Ligne ligne : this.lignes) {
			this.getChildren().add(ligne);
		}
		positionnerCarte();
	}

	public void dessine() {
		for (Ligne ligne : this.lignes) {
			ligne.dessine();
		}
		this.setSpacing(30);
	}

	public void positionnerCarte() {

		for (Ligne ligne : lignes) {

			for (EmplacementCarte emplacementCarte : ligne.getEmplacementCartesJ1()) {

				emplacementCarte.setOnMouseEntered(e -> {
					if (mainJoueur.getCarteSelectionne() != null && emplacementCarte.estVide())
						emplacementCarte.survolerEmplacement();
				});

				emplacementCarte.setOnMouseExited(e -> {
					if (mainJoueur.getCarteSelectionne() != null)
						emplacementCarte.quitterEmplacement();
				});
				emplacementCarte.setOnMouseClicked(e -> {
					if (mainJoueur.getCarteSelectionne() != null && emplacementCarte.estVide()) {
						emplacementCarte.setCarte(mainJoueur.getCarteSelectionne());
						emplacementCarte.quitterEmplacement();
						if (vainqueurPartie() == 1) {
							PopUpVictoire.affiche(mainJoueur.getNomJoueur());
						}
						else if (vainqueurPartie() == 2) {
							PopUpVictoire.affiche(mainIA.getNomJoueur());
						}
						this.mainJoueur.supprimerCarteSelectionne();
						this.mainJoueur.piocher();
						this.mainJoueur.toutDeselectionner();
					    this.ia.jouerCarte();
					    if (vainqueurPartie() == 1) {
							PopUpVictoire.affiche(mainJoueur.getNomJoueur());
						}
						else if (vainqueurPartie() == 2) {
							PopUpVictoire.affiche(mainIA.getNomJoueur());
						}
					}
				});
			}
		}
	}

	public int vainqueurPartie() {
		int scoreJ1 = 0;
		int scoreJ2 = 0;
		int borneConsecJ1 = 0;
		int borneConsecJ2 = 0;
		for (Ligne ligne : lignes) {
			if (ligne.mettreAJourAffrontements() == 1) {
				scoreJ1++;
				borneConsecJ1++;
				borneConsecJ2 = 0;
			}
			else if (ligne.mettreAJourAffrontements() == 2) {
				scoreJ2++;
				borneConsecJ2++;
				borneConsecJ1 = 0;
			}
			else if (ligne.mettreAJourAffrontements() == 0) {
				borneConsecJ1 = 0;
				borneConsecJ2 = 0;
			}
			if(borneConsecJ1 >= 3) {
				return 1;
			}
			else if(borneConsecJ2 >= 3) {
				return 2;
			}
		}
		if (scoreJ1 >= 5) {
			return 1;
		}
		else if (scoreJ2 >= 5) {
			return 2;
		}
		return 0;
	}

}
