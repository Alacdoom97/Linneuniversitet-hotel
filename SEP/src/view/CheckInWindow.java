package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CheckInWindow{
	public static final ObservableList names = FXCollections.observableArrayList();
	public static final ObservableList data = FXCollections.observableArrayList();
	public Button checkIn = new Button();
	public Button checkOut = new Button();
	public Stage guestWin = new Stage();
	GridPane gridy;

	public CheckInWindow(){
		cheWin();
		
	}
	public void cheWin(){
		Pane pane = new Pane();
		gridy = new GridPane();
		gridy.setAlignment(Pos.CENTER);
		gridy.setPadding(new Insets(40, 40, 40, 40));
		gridy.setGridLinesVisible(false);
		gridy.setTranslateX(200);
		gridy.setTranslateY(50);
		
		
		checkIn.setText("Check In");
		checkIn.setPrefSize(120, 120);
		checkIn.setTranslateX(45);
		
		checkOut.setText("Check Out");
		checkOut.setPrefSize(120, 120);
		checkOut.setTranslateX(45);
		
		
		for (int i = 0; i < 1; i++) {
			/*Creating the Columns and rows */
			ColumnConstraints columns = new ColumnConstraints();
			columns.setPercentWidth(250/3);
			gridy.getColumnConstraints().add(columns);
			
		}
		for (int i = 0; i < 5; i++) {
			/*Creating the Columns and rows */
			
			RowConstraints rows = new RowConstraints();
			rows.setPercentHeight(250/5);
			gridy.getRowConstraints().add(rows);
		}
		
		final ListView listView = new ListView(data);
		
		listView.setPrefSize(250, 450);
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
	        pane.getChildren().addAll(root, gridy);
	        root.getChildren().add(listView);
	        gridy.add(checkIn, 0, 0);
	        gridy.add(checkOut, 0, 2);
	        
	        
	        Scene scene = new Scene(pane, 500, 500);
	        guestWin.setScene(scene);
	        guestWin.show();
	}
}
