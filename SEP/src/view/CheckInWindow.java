package view;

import controller.CheckInController;
import controller.MainController;
import controller.ReservationController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Guest;
import model.GuestList;

public class CheckInWindow {
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public static final ObservableList<Guest> names = FXCollections.observableArrayList();
	public ListView listView;
	public Button searchButton = new Button();
	public Button checkIn = new Button();
	public Button checkOut = new Button();
	public Stage guestWin = new Stage();
	public TextField searchBar;
	public TextField searchBar2;
	public TextField name;
	public TextField lastName;
	public TextField address;
	public TextField birthday;
	public TextField isBusiness;
	public Label nameLab;
	public Label lastNameLab;
	public Label addressLab;
	public Label businessLab;
	public Label birthdayLab;
	public GuestList gueList;
	MainWindow mainWin =new MainWindow();
	ReservationController resControll = new ReservationController(this);
	CheckInController cheControll = new CheckInController(this);
	MainController mainControl = new MainController(mainWin);

	public CheckInWindow() {
		gueList = mainControl.gueList;
		cheWin();
	}

	@SuppressWarnings("unchecked")
	public void cheWin() {
		Pane pane = new Pane();

		// Create the buttons and searchBar for the GUI
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

		listView = new ListView(names);

		listView.setPrefSize(250, 450);
		listView.setEditable(true);

		Guest guest1 = new Guest(1, "", "Alfred", "Mourney", "Georg Lückligs Väg 22", "19810423-1234", false);
		Guest guest2 = new Guest(2, "", "Pranav", "Patel", "Lively Road 25", "19971125-2255", false);
		Guest guest3 = new Guest(3, "", "Stefan", "Bampovits", "Stuborvägen 15", "12345678-9123", false);
		Guest guest4 = new Guest(4, "", "Hau", "Trinh", "Kunggatan 10", "23456789-1234", false);
		Guest guest5 = new Guest(5, "", "Vikrant", "Mainali", "Fyllerydsvägen 43C", "34567891-2345", false);
		Guest guest6 = new Guest(6, "", "Pranav", "Patel", "Lundavägen 44", "19971125-2255", false);

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
		if (data.isEmpty()) {
			for (int i = 0; i < names.size(); i++) {
				data.add(names.get(i).idToString(names.get(i).getID()) + " " + names.get(i).getName() + " "
						+ names.get(i).getLastName());
			}
		}

		cheControll.checkInHandle();

		listView.setItems(data);

		// Double click the list to be able to see the
		
		StackPane root = new StackPane();
		pane.getChildren().addAll(root, searchBar, searchBar2, searchButton);
		root.getChildren().add(listView);

		Scene scene = new Scene(pane, 500, 500);
		guestWin.setScene(scene);
		guestWin.show();
	}
}
