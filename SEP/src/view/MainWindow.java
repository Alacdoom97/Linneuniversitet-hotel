package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	private RegistrationWindow regWin;
	private CheckinWindow cheWin;
	@Override
	public void start(Stage primaryStage) {
		VBox layout = new VBox();
		
		//This section creates the upper pane in the main window
		Pane topPane = new Pane();
		topPane.setPrefSize(200, 150);
		topPane.setStyle("-fx-background-color:grey");
		
		//CenterPane and the buttons.
		Pane centerPane = new Pane();
		centerPane.setPrefSize(800, 700);
		
		
		Button guestButton = new Button();
		guestButton.setText("Guest");
		guestButton.setPrefSize(120, 120);
		guestButton.setTranslateX(80);
		guestButton.setTranslateY(200);
		
		Button reservationButton = new Button();
		reservationButton.setText("Reservation");
		reservationButton.setPrefSize(120, 120);
		reservationButton.setTranslateX(450);
		reservationButton.setTranslateY(200);
		
		Button checkinButton = new Button();
		checkinButton.setText("Check in");
		checkinButton.setPrefSize(120, 120);
		checkinButton.setTranslateX(800);
		checkinButton.setTranslateY(200);
		
		centerPane.getChildren().addAll(guestButton, reservationButton, checkinButton);
		
		guestButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					
					regWin = new RegistrationWindow();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		checkinButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					cheWin = new CheckinWindow();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		
		layout.getChildren().addAll(topPane,centerPane);
		
		Scene scene = new Scene(layout, 1000, 800);
		
		primaryStage.setTitle("SEP");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
