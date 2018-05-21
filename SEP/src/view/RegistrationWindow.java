package view;

import java.time.LocalDate;

import controller.RegistrationController;
import database.SQLConnection;
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
	public TextField phoneNumber;
	public TextField lastname;
	public Label businessCheck;
	public boolean checkedIn = false;
	public DatePicker dateOfBirth = new DatePicker ();
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
		for (int i = 0; i < 8; i++) {
			/*Creating the Columns and rows */
			
			RowConstraints rows = new RowConstraints();
			rows.setPercentHeight(100.0/8);
			grid.getRowConstraints().add(rows);
		}
		
		accept.setPrefSize(120, 60);
		accept.setTranslateX(100);
		accept.setTranslateY(20);
		grid.add(accept, 0, 7);
		
		cancel.setPrefSize(120, 60);
		cancel.setTranslateX(100);
		cancel.setTranslateY(20);
		cancel.setText("Abort");
		grid.add(cancel, 1, 7);
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Business",
			        "Private"
			    );
			comboBox = new ComboBox(options);
			
			businessCheck = new Label("Reason for staying?");
			businessCheck.setTranslateX(100);
		
			grid.add(businessCheck, 0, 6);
			comboBox.setTranslateX(100);
			grid.add(comboBox, 1, 6);
		
		companyName = createTextField("Company Name: ", 0, 0);
		name = createTextField("Name: ", 0, 1);
		lastname = createTextField("Last Name: ", 0, 2);
		adress = createTextField("Address: ", 0, 3);
		phoneNumber = createTextField("Phone: ", 0,4);
		Label birthLabel= new Label("Birth date: ");
		birthLabel.setTranslateX(100);
		grid.add(birthLabel, 0, 5);		
		
		
		dateOfBirth.setTranslateX(100);
		dateOfBirth.setPromptText("YYYY-MM-DD");
		grid.add(dateOfBirth, 1, 5);
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
