package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class RegistrationWindow {
	
	ColumnConstraints columns;
	RowConstraints rows;
	GridPane grid;
	Button accept = new Button();
	
	
	public RegistrationWindow() {
		RegisWindow();
	}
	
	public void RegisWindow() {
		Stage regWin = new Stage();
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(40, 40, 40, 40));
		
		grid.setGridLinesVisible(false);
		
		for (int i = 0; i < 3; i++) {
			/*Creating the Columns and rows */
			ColumnConstraints columns = new ColumnConstraints();
			columns.setPercentWidth(100/3);
			grid.getColumnConstraints().add(columns);
			
		}
		for (int i = 0; i < 6; i++) {
			/*Creating the Columns and rows */
			
			RowConstraints rows = new RowConstraints();
			rows.setPercentHeight(100.0/6);
			grid.getRowConstraints().add(rows);
		}
		Button accept = new Button();
		accept.setPrefSize(120, 60);
		accept.setTranslateX(100);
		accept.setTranslateY(50);
		accept.setText("Confirm");
		grid.add(accept, 0, 5);
		Button cancel = new Button();
		cancel.setPrefSize(120, 60);
		cancel.setTranslateX(100);
		cancel.setTranslateY(50);
		cancel.setText("Abort");
		grid.add(cancel, 1, 5);
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Business",
			        "Private"
			    );
			final ComboBox<String> comboBox = new ComboBox<String>(options);
			
			Label businessCheck = new Label("Reason for staying? ");
			businessCheck.setTranslateX(100);
			businessCheck.setTranslateY(70);
			grid.add(businessCheck, 0, 4);
			comboBox.setTranslateY(70);
			comboBox.setTranslateX(100);
		grid.add(comboBox, 1, 4);
		
		createTextField("Company Name: ", 0, 0);
		createTextField("Name: ", 0, 1);
		createTextField("Last Name: ", 0, 2);
		createTextField("Address: ", 0, 3);
		Label birthLabel= new Label("Birthday: ");
		birthLabel.setTranslateX(100);
		grid.add(birthLabel, 0, 4);
		DatePicker textField = new DatePicker ();
		textField.setTranslateX(100);
		grid.add(textField, 1, 4);
		/*createTextField("Birthday: ", 0, 4);*/
		
		
		Scene regisWindow = new Scene(grid, 600, 800);
		regWin.setScene(regisWindow);
		regWin.show();
	}
	
	public void createTextField(String name, int column, int row) {
		Label label1 = new Label(name);
		label1.setTranslateX(100);
		grid.add(label1, column, row);
		TextField textField = new TextField ();
		textField.setTranslateX(100);
		grid.add(textField, column+1, row);
		
	}

	

}
