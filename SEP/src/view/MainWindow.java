package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox layout = new VBox();
		layout.setStyle("-fx-background-color:blue");
		
		Pane pane = new Pane();
		pane.setMaxSize(600, 600);
		
		pane.getChildren().addAll(layout);
		
		Scene scene = new Scene(pane, 800, 800);
		
		primaryStage.setTitle("SEP");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
