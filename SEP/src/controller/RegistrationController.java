package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import database.SQLConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.*;
import model.*;

public class RegistrationController {
	MainWindow mainWin = new MainWindow();
	MainController mainControl = new MainController(mainWin);
	RegistrationWindow main;
	ErrorWindow errWin;
	SQLConnection sql = new SQLConnection();
	private String companyName;
	private String name;
	private String lastName;
	private String adress;
	private String phoneNumber;
	private String personalNumber;
	private ArrayList<LocalDate> bookings = new ArrayList<LocalDate>();
	private Boolean isBusiness = null;
	private boolean isCheckedIn = false;

	public RegistrationController(RegistrationWindow main) {
		this.main = main;
		errWin = new ErrorWindow();
	}

	public void eventHandle() {
		main.accept.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					companyName = main.companyName.getText();
					name = main.name.getText();
					lastName = main.lastname.getText();
					adress = main.adress.getText();
					phoneNumber = main.phoneNumber.getText();
					LocalDate localdate = main.dateOfBirth.getValue();
					personalNumber = localdate.toString();

					if (main.comboBox.getValue() == "Business") {
						isBusiness = true;
					} else if (main.comboBox.getValue() == "Private") {
						isBusiness = false;
					}
					boolean validateGuest = guestValidation(name, lastName, adress, phoneNumber, personalNumber,
							isBusiness);

					if (validateGuest == true) {
						Guest guest = new Guest(mainControl.gl.getSize() + 1, companyName, name, lastName, adress,
								phoneNumber, personalNumber, isBusiness, isCheckedIn);

						if (mainControl.gl.getFromList(guest.getName(), guest.getPersNum()) == false) {
							System.out.println(mainControl.gl.getFromList(guest.getName(), guest.getLastName()));
							mainControl.gl.addToList(guest);
							System.out.println(guest.getName() + " " + guest.getLastName() + " " + guest.getPersNum());

							String query = "INSERT INTO GuestList(companyName,name,lastName,adress,phoneNumber,dateOfBirth,businessCheck,checkedIn)"
									+ "values('"+ companyName +"','"+name+"','"+
									lastName+"','"+adress+"','"+phoneNumber+"','"+
									personalNumber.toString()+"','"+
									isBusiness.toString()+"','"+Boolean.toString(isCheckedIn)+"')";
							
							sql.execute(query);
							main.regWin.close();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		main.cancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					main.regWin.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}

	public boolean guestValidation(String name, String lastname, String adress, String phone, String personalnr,
			Boolean isbusiness) {
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				errWin.nameError();
				return false;

			}

		}
		for (int i = 0; i < lastname.length(); ++i) {
			if (!Character.isLetter(lastname.charAt(i))) {
				errWin.nameError();
				return false;

			}
		}

		for (int i = 0; i < phone.length(); ++i) {
			if (!Character.isDigit(phone.charAt(i))) {
				errWin.phoneError();
				return false;
			}
		}

		return true;
	}

	public void showError() {
		System.err.print("name error");
	}

}
