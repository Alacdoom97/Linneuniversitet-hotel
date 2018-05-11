package view;

import java.time.LocalDate;

import controller.ReservationController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ReservationWindow {
	final ToggleGroup group = new ToggleGroup();
	final ToggleGroup group1 = new ToggleGroup();
	final ComboBox cBoxQuality = new ComboBox();
	final ComboBox cBoxBeds = new ComboBox();
	public Button guestButton = new Button();
	public Button newGuestButton = new Button();
	public Button confirmB = new Button("Confirm");
	public Button cancelB = new Button("Cancel");
	private ReservationController resControl = new ReservationController(this);
	public Stage resWin = new Stage();

	
	public ReservationWindow(){
		reservationWin();
	}
	
	public void reservationWin() {
		
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
		
		
		guestButton.setPrefSize(200, 20);
		guestButton.setText("Guests");
		grid.add(guestButton,2,1);
		
		
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
		checkInDate.setValue(LocalDate.now());
		DatePicker checkOutDate = new DatePicker();
		
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(LocalDate.now())) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE;");
						}
					}
				};
			}
		};
		
		final Callback<DatePicker, DateCell> dayCellFactory1 = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(LocalDate.now().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #EEEEEE;");
						}
					}
				};
			}
		};
		checkInDate.setDayCellFactory(dayCellFactory);
		checkOutDate.setDayCellFactory(dayCellFactory1);
			
		grid.add(checkInDate, 0, 1);
		grid.add(checkOutDate, 1, 1);
		
		cBoxBeds.getItems().addAll("Single Room", "Double Room", "Triple Room");
		cBoxBeds.setValue("Single Room");
		grid.add(cBoxBeds, 0, 3);
		
		RadioButton nonSmokeB = new RadioButton("Non-Smoking");
		RadioButton SmokeB = new RadioButton("Smoking");
		
		nonSmokeB.setToggleGroup(group1);
		nonSmokeB.setSelected(true);
		SmokeB.setToggleGroup(group1);
		
		grid.add(nonSmokeB, 0, 5);
		grid.add(SmokeB, 1, 5);
		
		
		
		confirmB.setTranslateX(270);
		
		
		cancelB.setTranslateX(100);
		
		
		grid.add(confirmB,1,12);
		grid.add(cancelB, 2, 12);
		
		cBoxQuality.getItems().addAll("1-Star", "2-Star", "3-Star");
		cBoxQuality.setValue("1-Star");
		grid.add(cBoxQuality, 0, 4);
		
		resControl.eventHandle();
		
		
		Scene scene = new Scene(grid, 800, 800);
		resWin.setScene(scene);
		resWin.show();
		
	}
}
