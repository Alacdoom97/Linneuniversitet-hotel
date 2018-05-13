package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.GuestList;
import view.CheckInWindow;
import view.GuestWindow;
import view.RegistrationWindow;
import view.ReservationWindow;

public class ReservationController {
	ReservationWindow main;
	RegistrationWindow regWin;
	GuestWindow guestWin;
	CheckInWindow cheWin;
	GuestList gueList;

	public ReservationController(ReservationWindow main) {
		this.main = main;

	}

	public void eventHandle() {
		main.newGuestButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					regWin = new RegistrationWindow();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		main.cancelB.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					main.resWin.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		main.guestButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					guestWin = new GuestWindow();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});

	}

}
