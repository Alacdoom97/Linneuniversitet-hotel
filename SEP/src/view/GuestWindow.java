package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.MainController;
import database.SQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Guest;
import model.GuestList;

public class GuestWindow{
	public static final ObservableList<Guest> names = FXCollections.observableArrayList();
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public final ListView listView = new ListView(data);
	public Stage guestWin = new Stage();

	private static GuestList gueList;
	CheckInWindow cheWin = new CheckInWindow();

	public TextField searchBar;
	public TextField searchBar2;
	public Button searchButton = new Button();

	MainWindow mainWin = new MainWindow();
	MainController mainCon = new MainController(mainWin);

	public GuestWindow(){
		
		gueList = mainCon.gl;
		guestWin();
	}
	public void guestWin(){
		Pane pane = new Pane();
		
		// Create the buttons and searchBar for the GUI

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
		
		listView.setPrefSize(200, 500);
		listView.setEditable(true);
		
		names.clear();
		data.clear();
		
		data.clear();
		names.clear();

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
			sq.DBDisconnector();
		}
	        
	        listView.setItems(data);
	        
	        
	        
	        
	        StackPane root = new StackPane();
			pane.getChildren().addAll(root, searchBar, searchBar2, searchButton);
			root.getChildren().add(listView);
	        
	        Scene scene = new Scene(pane, 500,500);
	        guestWin.setScene(scene);
	        guestWin.show();
	}
}
