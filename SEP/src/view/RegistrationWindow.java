package view;

import controller.RegistrationController;
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
	public Button accept = new Button("Confirm");
	public Button cancel = new Button();
	public TextField name;
	public TextField companyName;
	public TextField adress;
	public TextField lastname;
	public DatePicker textField = new DatePicker ();
	public ComboBox<String> comboBox;
	private RegistrationController regControl = new RegistrationController(this);
	public Stage regWin = new Stage();
	public RegistrationWindow() {
		RegisWindow();
	}
	
	public void RegisWindow() {
		
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
		
		accept.setPrefSize(120, 60);
		accept.setTranslateX(100);
		accept.setTranslateY(50);
		grid.add(accept, 0, 5);
		
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
			comboBox = new ComboBox(options);
			
			Label businessCheck = new Label("Reason for staying? ");
			businessCheck.setTranslateX(100);
			businessCheck.setTranslateY(70);
			grid.add(businessCheck, 0, 4);
			comboBox.setTranslateY(70);
			comboBox.setTranslateX(100);
		grid.add(comboBox, 1, 4);
		
		companyName = createTextField("Company Name: ", 0, 0);
		name = createTextField("Name: ", 0, 1);
		lastname = createTextField("Last Name: ", 0, 2);
		adress = createTextField("Address: ", 0, 3);
		Label birthLabel= new Label(": ");
		birthLabel.setTranslateX(100);
		grid.add(birthLabel, 0, 4);
		
		
		textField.setTranslateX(100);
		textField.setPromptText("YYYY-MM-DD");
		grid.add(textField, 1, 4);
		/*createTextField(": ", 0, 4);*/
		
		regControl.eventHandle();
		
		
		Scene regisWindow = new Scene(grid, 600, 800);
		regWin.setScene(regisWindow);
		regWin.show();
	}
	
	public TextField createTextField(String name, int column, int row) {
		Label label1 = new Label(name);
		label1.setTranslateX(100);
		grid.add(label1, column, row);
		TextField textField = new TextField ();
		textField.setTranslateX(100);
		grid.add(textField, column+1, row);
		return textField;
		
	}

	

}
