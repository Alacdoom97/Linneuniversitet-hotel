package controller;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.*;
import model.*;
public class RegistrationController {
	RegistrationWindow main;
	private String companyName;
	private String name;
	private String lastName;
	private String adress;
	private String personalNumber;
	private ArrayList<LocalDate> bookings = new ArrayList<LocalDate>();
	private boolean isBusiness;
	
	public RegistrationController(RegistrationWindow main){
		this.main = main;
	}
	
	public void eventHandle(){
		main.accept.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					companyName = main.companyName.getText();
					name = main.name.getText();
					lastName = main.lastname.getText();
					adress = main.adress.getText();
					personalNumber = main.textField.toString();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
	}

}
