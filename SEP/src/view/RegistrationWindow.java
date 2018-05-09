package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RegistrationWindow {
	
	public RegistrationWindow() {
		RegisWindow();
	}
	
	public void RegisWindow() {
		Stage regWin = new Stage();
		Group group = new Group();
		Button accept = new Button();
		accept.setLayoutX(0);
		accept.setLayoutY(700);
		accept.setText("Confirm");
		Button cancel = new Button();
		HBox companyName = createTextField("Company Name");
		HBox name = createTextField("Company Name");
		HBox lastName = createTextField("Company Name");
		HBox address = createTextField("Company Name");
		HBox birthday = createTextField("Company Name");
		group.getChildren().addAll(accept, cancel, companyName, name, lastName, address, birthday);
		Scene regisWindow = new Scene(group, 600, 800);
		regWin.setScene(regisWindow);
		regWin.show();
	}
	
	public HBox createTextField(String name) {
		Label label1 = new Label(name);
		TextField textField = new TextField ();
		HBox hb = new HBox();
		hb.getChildren().addAll(label1, textField);
		hb.setSpacing(10);
		
		return hb;
	}

	

}
