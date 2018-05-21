package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.CheckInController;
import controller.MainController;
import controller.ReservationController;
import database.SQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	public TextField phone;
	public TextField birthday;
	public TextField isBusiness;
	public Label nameLab;
	public Label lastNameLab;
	public Label addressLab;
	public Label phoneLab;
	public Label businessLab;
	public Label birthdayLab;
	public static GuestList gueList;
	MainWindow mainWin = new MainWindow();
	ReservationController resControll = new ReservationController(this);
	CheckInController cheControll = new CheckInController(this);
	MainController mainControl = new MainController(mainWin);

	public CheckInWindow() {
		gueList = mainControl.gl;
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


		/*for (int i = 0; i < gueList.getSize(); ++i) {
			names.add(gueList.getGuest(i));
		}
		data.clear();
		names.clear();*/

		SQLConnection sq = new SQLConnection();
		String query = "SELECT * from GuestList";
		ResultSet rs = sq.importData(query);

		try {
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String companyName = rs.getString("companyName");
				String firstName = rs.getString("name");
				String lastName = rs.getString("lastname");
				String address = rs.getString("adress");
				String phoneNumber = rs.getString("phoneNumber");
				String birthday = rs.getString("dateOfBirth");
				Boolean isBusiness = rs.getBoolean("businessCheck");
				Guest guest = new Guest(ID, companyName, firstName, lastName, address, phoneNumber, birthday,
						isBusiness, false);

				names.add(guest);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (data.isEmpty()) {
			for (int i = 0; i < names.size(); i++) {
				data.add(names.get(i).getName() + " " + names.get(i).getLastName());
			}
		}
		// click the list to be able to see the guest info
		cheControll.checkInHandle(gueList);
		

		listView.setItems(data);

		

		StackPane root = new StackPane();
		pane.getChildren().addAll(root, searchBar, searchBar2, searchButton);
		root.getChildren().add(listView);

		Scene scene = new Scene(pane, 500, 500);
		guestWin.setScene(scene);
		guestWin.show();
	}
}
