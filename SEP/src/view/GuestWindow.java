package view;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.GuestList;

public class GuestWindow{
	public static final ObservableList names = FXCollections.observableArrayList();
	public static final ObservableList data = FXCollections.observableArrayList();
	public Stage guestWin = new Stage();
	private GuestList gueList;
	MainWindow mainWin = new MainWindow();
	MainController mainCon = new MainController(mainWin);

	public GuestWindow(){
		gueList = mainCon.gl;
		guestWin();
	}
	public void guestWin(){
		final ListView listView = new ListView(data);
		
		listView.setPrefSize(200, 250);
		listView.setEditable(true);
		
		names.addAll(
	             "Adam", "Alex", "Alfred", "Albert",
	             "Brenda", "Connie", "Derek", "Donny", 
	             "Lynne", "Myrtle", "Rose", "Rudolph", 
	             "Tony", "Trudy", "Williams", "Zach"
	        );
	         
	        for (int i = 0; i < names.size(); i++) {
	            data.add(names.get(i).toString());
	        }
	        
	        for (int i = 0; i < names.size(); i++) {
	            data.add(names.get(i).toString());
	        }
	          
	        listView.setItems(data);
	        
	        
	        StackPane root = new StackPane();
	        
	        root.getChildren().add(listView);
	        
	        Scene scene = new Scene(root, 200,250);
	        guestWin.setScene(scene);
	        guestWin.show();
	}
}
