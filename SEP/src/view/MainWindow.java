package view;

import controller.MainController;
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

	static MainController winCont;
	private RegistrationWindow regWin;
	private GuestWindow gueWin;
	private ReservationWindow resWin;
	public Button guestButton = new Button();
	public Button reservationButton = new Button();
	public Button checkinButton = new Button();
	public Button guestListButton = new Button();
	private MainController mainC = new MainController(this);
	
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
		
		
		
		guestButton.setText("Guest");
		guestButton.setPrefSize(120, 120);
		guestButton.setTranslateX(80);
		guestButton.setTranslateY(200);
		
		
		reservationButton.setText("Reservation");
		reservationButton.setPrefSize(120, 120);
		reservationButton.setTranslateX(450);
		reservationButton.setTranslateY(200);
		
		
		checkinButton.setText("Check in");
		checkinButton.setPrefSize(120, 120);
		checkinButton.setTranslateX(800);
		checkinButton.setTranslateY(200);
		
		guestListButton.setText("Guest List");
		guestListButton.setPrefSize(120, 120);
		guestListButton.setTranslateX(450);
		guestListButton.setTranslateY(500);
		
		centerPane.getChildren().addAll(guestButton, reservationButton, checkinButton, guestListButton);
		
		mainC.eventHandle();
		
		
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
