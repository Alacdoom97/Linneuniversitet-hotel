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
	private Boolean isBusiness = null; 
	private GuestList gl = new GuestList();
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
					LocalDate localdate = main.textField.getValue();
					personalNumber = localdate.toString();
					if(main.comboBox.getValue() == "Business"){
						isBusiness = true;
					}
					else if(main.comboBox.getValue() == "Private") {
						isBusiness = false;
					}
					System.out.println(companyName+","+name+","+ lastName+","+ personalNumber+","+ isBusiness);
					guestValidation(name,lastName,adress,personalNumber,isBusiness);
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		main.cancel.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					main.regWin.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
	}
	
	public boolean guestValidation(String name, String lastname, String adress, String personalnr, Boolean isbusiness){
		if(name == null || lastname == null|| adress == null || personalnr == null || isbusiness == null ){
			showError();
		}
		return false;
		
	}
	
	public void showError(){
		System.err.print("Something is missing, please input all fields!");		
	}

}
