package logique_jeu;

import java.util.LinkedList;

import interface_graphique.CarteG;
import interface_graphique.Ligne;
import interface_graphique.MainG;

public class IAAleatoire extends IA {

	public IAAleatoire(MainG mainIA, LinkedList<Ligne> lignes) {
		super(mainIA, lignes);
	}

	public void jouerCarte() {
		CarteG carteJouee = this.mainIA.getCarteAleatoire();
		boolean cartePosee = false;
		while (!cartePosee) {
			int numeroLigne = (int) (Math.random() * 9);
			for(int i = 2; i >= 0; i--) {
				if (this.lignes.get(numeroLigne).getEmplacementCarteJ2().get(i).estVide()) {
					this.lignes.get(numeroLigne).getEmplacementCarteJ2().get(i).setCarte(carteJouee);
					this.lignes.get(numeroLigne).getEmplacementCarteJ2().get(i).getCarteG().afficherCarte();
					this.mainIA.piocher();
					this.mainIA.cacherMain();
					cartePosee = true;
					return;
				}
			}

		}
	}

}
