package view;

import java.time.LocalDate;
import java.util.List;

import controller.ReservationController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ReservationWindow {
	final ToggleGroup group = new ToggleGroup();
	final ToggleGroup group1 = new ToggleGroup();
	final ComboBox cBoxQuality = new ComboBox();
	final ComboBox cBoxBeds = new ComboBox();
	final ComboBox cBoxSmoke = new ComboBox();
	public Button guestButton = new Button();
	public Button newGuestButton = new Button();
	public Button confirmB = new Button("Confirm");
	public Button cancelB = new Button("Cancel");
	public Button searchButton = new Button("Search");
	public Button previousButton = new Button("<");
	public Button nextButton = new Button(">");
	public Label name = new Label();
	public Label birthday = new Label();
	public Label country = new Label();
	public Label address = new Label();
	public Label phone = new Label();
	private ReservationController resControl = new ReservationController(this);
	public Stage resWin = new Stage();
	final ObservableList<String> months = FXCollections.observableArrayList();
	public LocalDate dateChecker = LocalDate.now();
	private DatePicker checkInDate = new DatePicker();
	private DatePicker checkOutDate = new DatePicker();
	public Pane pane = new GridPane();
	public Label monthLabel;
	public Pane layout = new Pane();
	public GridPane grid2 = new GridPane();
	public GridPane grid1 = new GridPane();
	
	
	public ReservationWindow(){
		reservationWin();
	}
	
	public void reservationWin() {
		
		months.addAll("January","February","March","April","May","June","July"
				,"August", "September", "October","November", "December");
		
		resWin.setTitle("Reservation Manager");
		
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setPadding(new Insets(40,20,20,20));
		grid.setPrefSize(1000, 200);
		grid.setTranslateZ(10);
		int colMax = 4;
		int rowMax = 4;
		
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
		
		
		
		
		searchButton.setPrefSize(200,20);
		searchButton.setText("Search");
		grid.add(searchButton, 2, 3);
		
		Label arrivalLabel = new Label("Arrival");
		arrivalLabel.setTranslateY(10);
		grid.add(arrivalLabel, 0, 0);
		
		Label departureLabel = new Label("Departure");
		departureLabel.setTranslateY(10);
		grid.add(departureLabel, 1, 0);
		
		TextField roomNrTF = new TextField();
		roomNrTF.setPromptText("Room nr");
		
		
		
		
		
		checkInDate.setValue(LocalDate.now());
		
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
		grid.add(cBoxBeds, 0, 2);
		
		cBoxSmoke.getItems().addAll("Non-smoker", "Smoker");
		cBoxSmoke.setValue("Non-smoker");
		grid.add(cBoxSmoke, 0, 3);
		
		
		
		
		
		
		cBoxQuality.getItems().addAll("1-Star", "2-Star", "3-Star");
		cBoxQuality.setValue("1-Star");
		grid.add(cBoxQuality, 1, 2);
		
		resControl.eventHandle();
		grid1.setGridLinesVisible(false);
		grid1.setPrefSize(400, 800);
		grid1.setTranslateX(1050);
		grid1.setTranslateY(35);
		
		int rowMax1 = 16;
		int colMax1 = 1;
		
		for (int i = 0; i < rowMax1; ++i){
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0/rowMax1);
			grid1.getRowConstraints().add(rowConst);
		}
		
		for(int i = 0; i < colMax1; ++i){
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0/colMax1);
			grid1.getColumnConstraints().add(colConst);
		}
		
		guestButton.setPrefSize(150, 20);
		guestButton.setText("Guests");
		grid1.add(guestButton,0,0);
		
		
		newGuestButton.setPrefSize(150, 20);
		newGuestButton.setText("New Guest");
		newGuestButton.setTranslateX(200);
		grid1.add(newGuestButton, 0, 0);
		for (int i = 1; i < 15; i += 2){
			grid1.add(cellFill("-fx-background-color:grey"),0, i);	
		}
		
		grid1.add(textLabel("Name"), 0, 1);
		grid1.add(name, 0, 2);
		grid1.add(textLabel("Birthdate"), 0, 3);
		grid1.add(birthday, 0, 4);
		grid1.add(textLabel("Country"), 0, 5);
		
		grid1.add(textLabel("Adress"), 0, 7);
		grid1.add(address, 0, 8);
		grid1.add(textLabel("Phone"), 0, 9);
		
		confirmB.setTranslateX(200);
		grid1.add(confirmB, 0, 15);
		cancelB.setTranslateX(280);
		grid1.add(cancelB, 0, 15);
		
		
		
		grid2.setGridLinesVisible(true);
		grid2.setPrefSize(1000, 625);
		grid2.setStyle("-fx-background-color:grey");
		grid2.setTranslateX(20);
		grid2.setTranslateY(230);
		
		int rowMax2 = 31;
		int colMax2 = 32;
		
		for (int i = 0; i < rowMax2; ++i){
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0/rowMax2);
			grid2.getRowConstraints().add(rowConst);
		}
		
		for(int i = 0; i < colMax2; ++i){
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0/colMax2);
			grid2.getColumnConstraints().add(colConst);
		}
		int y = 0;
		
		for(int i = 0; i < 31; ++i){
			grid2.add(textLabel(Integer.toString(i+1)), i+1, 0);
		}
		
		for(int i = 0; i < 30; ++i){
			grid2.add(textLabel(Integer.toString(i+1)), 0, i+1);
		}
		
		grid2.add(cellFill("-fx-background-color:green"), 5, 5);
		
		
		pane.setTranslateX(19);
		pane.setTranslateY(198);
		pane.setPrefSize(1002, 20);
		nextButton.setTranslateX(971);
		pane.getChildren().addAll(nextButton, previousButton);
		layout.getChildren().addAll(grid, grid1,grid2,pane);
		monthDisplay(dateChecker);
		
		
		Scene scene = new Scene(layout, 1500, 900);
		resWin.setScene(scene);
		resWin.show();
		
	}
	
	public StackPane cellFill(String color){
		StackPane sp = new StackPane();
		sp.setStyle(color);
		return sp;
	}
	
	public Label textLabel(String text){
		Label tl = new Label(text);
		return tl;
	}
	
	public void monthDisplay(LocalDate date){
		monthLabel = new Label(months.get(date.getMonthValue()-1));
		monthLabel.setTranslateX(475);
		pane.getChildren().add(monthLabel);
	}
	
	public GridPane newGrid(){
		GridPane newGp = new GridPane();
		newGp.setGridLinesVisible(true);
		newGp.setPrefSize(1000, 625);
		newGp.setStyle("-fx-background-color:grey");
		newGp.setTranslateX(20);
		newGp.setTranslateY(230);
		
		int rowMax2 = 31;
		int colMax2 = 32;
		
		for (int i = 0; i < rowMax2; ++i){
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0/rowMax2);
			newGp.getRowConstraints().add(rowConst);
		}
		
		for(int i = 0; i < colMax2; ++i){
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0/colMax2);
			newGp.getColumnConstraints().add(colConst);
		}
		int y = 0;
		
		for(int i = 0; i < 31; ++i){
			newGp.add(textLabel(Integer.toString(i+1)), i+1, 0);
		}
		
		for(int i = 0; i < 30; ++i){
			newGp.add(textLabel(Integer.toString(i+1)), 0, i+1);
		}
		return newGp;
	}
	
	
}
