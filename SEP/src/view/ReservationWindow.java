package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ReservationWindow {
	final ToggleGroup group = new ToggleGroup();
	final ToggleGroup group1 = new ToggleGroup();

	
	public ReservationWindow(){
		reservationWin();
	}
	public void reservationWin() {
		Stage resWin = new Stage();
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(true);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setPadding(new Insets(40,20,20,20));
		int colMax = 3;
		int rowMax = 14;
		
		for(int i = 0; i < colMax; ++i){
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0/colMax);
			grid.getColumnConstraints().add(colConst);
		}
		
		for (int i = 0; i < rowMax; ++i){
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0/rowMax);
			grid.getRowConstraints().add(rowConst);
		}
		
		Button guestButton = new Button();
		guestButton.setPrefSize(200, 20);
		guestButton.setText("Guests");
		grid.add(guestButton,2,1);
		
		Button newGuestButton = new Button();
		newGuestButton.setPrefSize(200, 20);
		newGuestButton.setText("New Guest");
		grid.add(newGuestButton, 2, 2);
		
		Label arrivalLabel = new Label("Arrival");
		arrivalLabel.setTranslateY(15);
		grid.add(arrivalLabel, 0, 0);
		
		Label departureLabel = new Label("Departure");
		departureLabel.setTranslateY(15);
		grid.add(departureLabel, 1, 0);
		
		
		DatePicker checkInDate = new DatePicker();
		DatePicker checkOutDate = new DatePicker();
		grid.add(checkInDate, 0, 1);
		grid.add(checkOutDate, 1, 1);
		
		RadioButton singleRoomButton = new RadioButton("Single room");
		RadioButton doubleRoomButton = new RadioButton("Double room");
		RadioButton tripleRoomButton = new RadioButton("Triple room");
		singleRoomButton.setToggleGroup(group);
		singleRoomButton.setSelected(true);
		doubleRoomButton.setToggleGroup(group);
		tripleRoomButton.setToggleGroup(group);
		
		grid.add(singleRoomButton, 0, 3);
		grid.add(doubleRoomButton, 1, 3);
		grid.add(tripleRoomButton, 0, 4);
		
		RadioButton nonSmokeB = new RadioButton("Non-Smoking");
		RadioButton SmokeB = new RadioButton("Smoking");
		
		nonSmokeB.setToggleGroup(group1);
		nonSmokeB.setSelected(true);
		SmokeB.setToggleGroup(group1);
		
		grid.add(nonSmokeB, 0, 6);
		grid.add(SmokeB, 1, 6);
		
		Scene scene = new Scene(grid, 800, 800);
		resWin.setScene(scene);
		resWin.show();
		
	}
}
