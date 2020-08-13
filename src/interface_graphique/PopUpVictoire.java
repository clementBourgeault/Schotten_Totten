package interface_graphique;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpVictoire {

	public static void affiche(String vainqueur) {
		Stage popUp = new Stage();

		popUp.initModality(Modality.APPLICATION_MODAL);
		popUp.setMinWidth(250);
		popUp.setMinHeight(100);

		Label label = new Label();
		label.setText("Victoire de " + vainqueur);

		Button boutonRejouer = new Button("Rejouer");
		Button boutonQuitter = new Button("Quitter");

		HBox boutons = new HBox(10);
		boutons.getChildren().addAll(boutonRejouer, boutonQuitter);

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(label, boutons);

		Scene scene = new Scene(vBox);

		popUp.setScene(scene);

		popUp.show();

	}

}
