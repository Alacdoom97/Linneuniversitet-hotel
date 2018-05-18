package view;

import controller.MainController;
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
	public TextField searchBar;
	public TextField searchBar2;
	public Button searchButton = new Button();
	private GuestList gueList;
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
		
		for (int i = 0; i < gueList.getSize(); i++) {
			names.add(gueList.getGuest(i));
		}
	         
	        for (int i = 0; i < names.size(); i++) {
	            data.add(names.get(i).idToString(names.get(i).getID()) + " " + names.get(i).getName() + " "
	            								 + names.get(i).getLastName());
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
