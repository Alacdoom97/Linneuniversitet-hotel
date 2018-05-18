package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorWindow {
	
	public void nameError() {
		Alert nameAlert = new Alert(AlertType.ERROR);
		nameAlert.setTitle("Error!");
		nameAlert.setHeaderText("An Error has occured");
		nameAlert.setContentText("Name can only contain letters!");
		nameAlert.showAndWait();
	}
	
	

}
