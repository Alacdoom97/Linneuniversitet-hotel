package view;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Guest;

public class CheckInWindow{
	public static final ObservableList<Guest> data = FXCollections.observableArrayList();
	public static final ObservableList<String> names = FXCollections.observableArrayList();
	public Button checkIn = new Button();
	public Button checkOut = new Button();
	public Stage guestWin = new Stage();
	GridPane gridy;

	public CheckInWindow(){
		cheWin();
		
	}
	@SuppressWarnings("unchecked")
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
		
		final ListView<Guest> listView = new ListView<Guest>(data);
		
		listView.setPrefSize(250, 450);
		listView.setEditable(true);
		
		data.add(new Guest("","Alfred", "Mourney", "Georg Lückligs Väg 22", null, false));
	         
	        for (int i = 0; i < names.size(); i++) {
	            names.add(data.get(i).getName().toString() + " " + data.get(i).getLastName().toString());
	        }
	        
	        
	          
	        listView.setItems(data);
	        
	        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        	@Override
	        	public void handle(MouseEvent event) {
	        		
	        		if(event.getButton().equals(MouseButton.PRIMARY)) {
	        			if(event.getClickCount() == 2) {
	        				Guest guest = listView.getSelectionModel().getSelectedItem();
	        				if(guest != null) {
	        					Pane listPane = new Pane();
	        					Scene listScene = new Scene(pane, 500, 500);
	        					Stage listStage = new Stage();
	        					listStage.setScene(listScene);
	        					listStage.show();
	        				}
	        			}
	        		}
	        	}
	        });
	        
	       
	       
	        
	        
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
