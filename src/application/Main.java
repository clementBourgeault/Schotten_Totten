package application;

import interface_graphique.JeuEntier;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		JeuEntier jeu = new JeuEntier();
		jeu.dessine();

		Scene scene = new Scene(jeu);

		stage.setScene(scene);

		stage.setTitle("Schotten Totten");
		stage.setMaximized(true);
		stage.show();

	}

}
