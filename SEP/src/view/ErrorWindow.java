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
	
	public void checkedInAlert() {
		Alert checkedIn = new Alert(AlertType.CONFIRMATION);
		checkedIn.setTitle("Success!");
		checkedIn.setHeaderText("Successfully Checked in");
		checkedIn.setContentText("Guest has been successfully checked in!");
		checkedIn.showAndWait();
	}
	
	public void checkedOutAlert() {
		Alert checkedOut = new Alert(AlertType.CONFIRMATION);
		checkedOut.setTitle("Success!");
		checkedOut.setHeaderText("Successfully Checked Out");
		checkedOut.setContentText("Guest has been successfully checked out!");
		checkedOut.showAndWait();
	}
	
	public void roomLocatedAlert() {
		Alert roomLocated = new Alert(AlertType.CONFIRMATION);
		roomLocated.setTitle("Room Noted!");
		roomLocated.setContentText("Room has bee succesfully noted down!");
		roomLocated.showAndWait();
	}
	
	public void reservationError() {
		Alert reserveError = new Alert(AlertType.ERROR);
		reserveError.setTitle("Error!");
		reserveError.setHeaderText("Fields missing!");
		reserveError.setContentText("There are some fields missing! All Fields must be filled in!");
		reserveError.showAndWait();
	}

}
