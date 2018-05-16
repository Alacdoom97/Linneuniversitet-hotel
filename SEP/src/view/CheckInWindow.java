package view;

import java.time.LocalDate;

import controller.ReservationController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Guest;
import model.GuestList;

public class CheckInWindow {
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public static final ObservableList<Guest> names = FXCollections.observableArrayList();
	public Button searchButton = new Button();
	public Button checkIn = new Button();
	public Button checkOut = new Button();
	public Stage guestWin = new Stage();
	public TextField searchBar;
	public TextField searchBar2;
	public GuestList gueList;
	ReservationController resControll = new ReservationController(this);

	public CheckInWindow() {
		gueList = new GuestList();
		cheWin();
	}

	@SuppressWarnings("unchecked")
	public void cheWin() {
		Pane pane = new Pane();
		
		//Create the buttons and searchBar for the GUI
		checkIn.setText("Check In");
		checkIn.setPrefSize(120, 120);
		checkIn.setTranslateX(125);
		checkIn.setTranslateY(300);

		checkOut.setText("Check Out");
		checkOut.setPrefSize(120, 120);
		checkOut.setTranslateX(275);
		checkOut.setTranslateY(300);

		searchButton.setText("Search");
		searchButton.setTranslateX(300);
		searchButton.setTranslateY(160);

		searchBar = new TextField();
		searchBar.setPromptText("Enter Name");
		searchBar.setTranslateX(300);
		searchBar.setTranslateY(100);

		searchBar2 = new TextField();
		searchBar2.setPromptText("Enter Personal Number");
		searchBar2.setTranslateX(300);
		searchBar2.setTranslateY(130);

		final ListView listView = new ListView<>(names);

		listView.setPrefSize(250, 450);
		listView.setEditable(true);

		Guest guest1 = new Guest("", "Alfred", "Mourney", "Georg Lückligs Väg 22", "19810423-1234", false);
		Guest guest2 = new Guest("", "Pranav", "Patel", "Lively Road 25", "19971125-2255", false);
		Guest guest3 = new Guest("", "Stefan", "Bampovits", "Stuborvägen 15", "12345678-9123", false);
		Guest guest4 = new Guest("", "Hau", "Trinh", "Kunggatan 10", "23456789-1234", false);
		Guest guest5 = new Guest("", "Vikrant", "Mainali", "Fyllerydsvägen 43C", "34567891-2345", false);
		Guest guest6 = new Guest("", "Pranav", "Patel", "Lundavägen 44", "19971125-2255", false);

		gueList.addToList(guest1);
		gueList.addToList(guest2);
		gueList.addToList(guest3);
		gueList.addToList(guest4);
		gueList.addToList(guest5);
		gueList.addToList(guest6);

		names.add(guest1);
		names.add(guest2);
		names.add(guest3);
		names.add(guest4);
		names.add(guest5);
		names.add(guest6);

		for (int i = 0; i < names.size(); i++) {
			data.add(names.get(i).getName() + " " + names.get(i).getLastName());
		}
		
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent search) {
				try {
					names.clear();
					data.clear();
					for (int i = 0; i < gueList.getSize(); i++) {
						Guest guest = gueList.getGuest(i);
						if (searchBar.getText().equals(guest.getName()) && searchBar2.getText().equals(guest.getPersNum())) {
							names.add(guest);
						}
					}
					
					for(int i = 0; i < names.size(); i++) {
						data.add(names.get(i).getName() + " " + names.get(i).getLastName());
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		
		

		listView.setItems(data);
		
		//Double click the list to be able to see the 
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Guest tempGuest = names.get(0);
				if (tempGuest != null) {
					Pane listPane = new Pane();
					Scene listScene = new Scene(listPane, 500, 500);
					Stage listStage = new Stage();

					Label nameLab = new Label("Name: ");
					nameLab.setTranslateY(10);

					TextField name = new TextField(tempGuest.getName());
					name.setEditable(false);
					name.setTranslateX(60);
					name.setTranslateY(10);

					Label lastNameLab = new Label("Last Name: ");
					lastNameLab.setTranslateY(40);

					TextField lastName = new TextField(tempGuest.getLastName());
					lastName.setEditable(false);
					lastName.setTranslateX(60);
					lastName.setTranslateY(40);

					Label addressLab = new Label("Address: ");
					addressLab.setTranslateY(70);

					TextField address = new TextField(tempGuest.getAdress());
					address.setEditable(false);
					address.setTranslateY(70);
					address.setTranslateX(60);

					Label birthdayLab = new Label("Birthday: ");
					birthdayLab.setTranslateY(100);

					TextField birthday = new TextField(tempGuest.getPersNum());
					birthday.setEditable(false);
					birthday.setTranslateY(100);
					birthday.setTranslateX(60);

					Label businessLab = new Label("Business stay: ");
					businessLab.setTranslateY(130);

					TextField isBusiness = new TextField(tempGuest.booleanToString(tempGuest.isBusiness()));
					isBusiness.setEditable(false);
					isBusiness.setTranslateY(130);
					isBusiness.setTranslateX(80);

					listPane.getChildren().addAll(name, nameLab, lastName, lastNameLab, address, addressLab, birthday,
							birthdayLab, isBusiness, businessLab, checkIn, checkOut);
					listStage.setScene(listScene);
					listStage.show();
				}
			}

		});

		StackPane root = new StackPane();
		pane.getChildren().addAll(root, searchBar, searchBar2, searchButton);
		root.getChildren().add(listView);

		Scene scene = new Scene(pane, 500, 500);
		guestWin.setScene(scene);
		guestWin.show();
	}
}
