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
	
	public void birthDayError(){
		Alert bDayAlert = new Alert(AlertType.ERROR);
		bDayAlert.setTitle("Error!");
		bDayAlert.setHeaderText("An Error has occured");
		bDayAlert.setContentText("Invalid date input");
		bDayAlert.showAndWait();
	}
	
	public void phoneError(){
		Alert phoneAlert = new Alert(AlertType.ERROR);
		phoneAlert.setTitle("Error");
		phoneAlert.setHeaderText("An Error has occured");
		phoneAlert.setContentText("Invalid phone number");
		phoneAlert.showAndWait();
	}
	
	

}
