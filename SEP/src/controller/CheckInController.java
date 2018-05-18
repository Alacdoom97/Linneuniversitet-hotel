package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Guest;
import model.GuestList;
import view.CheckInWindow;
import view.GuestWindow;
import view.ReservationWindow;

public class CheckInController {
	
	static CheckInWindow cheWin;
	static ReservationWindow resWin;
	public GuestWindow gueWin;
	
	public CheckInController(CheckInWindow checkIn) {
		cheWin = checkIn;
	}
	
	public void checkInHandle(GuestList gueList) {
		cheWin.searchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent search) {
				try {
					cheWin.names.clear();
					cheWin.data.clear();
					for (int i = 0; i < gueList.getSize(); i++) {
						Guest guest = gueList.getGuest(i);
						if (cheWin.searchBar.getText().equals(guest.getName())
								&& cheWin.searchBar2.getText().equals(guest.getPersNum())) {
							cheWin.names.add(guest);
						}
					}

					for (int i = 0; i < cheWin.names.size(); i++) {
						cheWin.data.add(cheWin.names.get(i).idToString(cheWin.names.get(i).getID()) + " " + cheWin.names.get(i).getName() + " "
								+ cheWin.names.get(i).getLastName());
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		
		cheWin.listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Guest tempGuest = null;
				for (int i = 0; i < cheWin.names.size(); i++) {
					if (cheWin.listView.getSelectionModel().getSelectedItem()
							.equals(cheWin.names.get(i).idToString(cheWin.names.get(i).getID()) + " " + cheWin.names.get(i).getName() + " "
									+ cheWin.names.get(i).getLastName())) {
						tempGuest = cheWin.names.get(i);
					}
				}

				if (tempGuest != null) {
					Pane listPane = new Pane();
					Scene listScene = new Scene(listPane, 500, 500);
					Stage listStage = new Stage();

					cheWin.nameLab = new Label("Name: ");
					cheWin.nameLab.setTranslateY(10);

					cheWin.name = new TextField(tempGuest.getName());
					cheWin.name.setEditable(false);
					cheWin.name.setTranslateX(80);
					cheWin.name.setTranslateY(10);

					cheWin.lastNameLab = new Label("Last Name: ");
					cheWin.lastNameLab.setTranslateY(40);

					cheWin.lastName = new TextField(tempGuest.getLastName());
					cheWin.lastName.setEditable(false);
					cheWin.lastName.setTranslateX(80);
					cheWin.lastName.setTranslateY(40);

					cheWin.addressLab = new Label("Address: ");
					cheWin.addressLab.setTranslateY(70);

					cheWin.address = new TextField(tempGuest.getAdress());
					cheWin.address.setEditable(false);
					cheWin.address.setTranslateY(70);
					cheWin.address.setTranslateX(80);

					cheWin.birthdayLab = new Label("Birthday: ");
					cheWin.birthdayLab.setTranslateY(100);

					cheWin.birthday = new TextField(tempGuest.getPersNum());
					cheWin.birthday.setEditable(false);
					cheWin.birthday.setTranslateY(100);
					cheWin.birthday.setTranslateX(80);

					cheWin.businessLab = new Label("Business stay: ");
					cheWin.businessLab.setTranslateY(130);

					cheWin.isBusiness = new TextField(tempGuest.booleanToString(tempGuest.isBusiness()));
					cheWin.isBusiness.setEditable(false);
					cheWin.isBusiness.setTranslateY(130);
					cheWin.isBusiness.setTranslateX(80);

					listPane.getChildren().addAll(cheWin.name, cheWin.nameLab, cheWin.lastName, cheWin.lastNameLab, cheWin.address, cheWin.addressLab, cheWin.birthday,
							cheWin.birthdayLab, cheWin.isBusiness, cheWin.businessLab, cheWin.checkIn, cheWin.checkOut);
					listStage.setScene(listScene);
					listStage.show();
				}
			}
		});
	}

}
