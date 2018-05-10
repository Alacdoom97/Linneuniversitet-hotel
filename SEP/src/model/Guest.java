package model;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Guest {
	private StringProperty firstName = null;
	private StringProperty sirName = null;
	private String companyName;
	private String name;
	private String lastName;
	private String adress;
	private LocalDate birthday;
	private boolean isBusiness;
	
	public Guest(){
		createGuest("", "", "", LocalDate.now(), false);
	}
	public Guest(String company, String name, String lastName, String address, LocalDate birthday, boolean isBusiness){
		companyName = company;
		this.name = name;
		this.lastName = lastName;
		this.adress = address;
		this.birthday = birthday;
		this.isBusiness = isBusiness;
	}
	
	public void createGuest(String name, String lastname, String adress, LocalDate birthday, boolean isBusiness){
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.firstName = new SimpleStringProperty(name);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.sirName = new SimpleStringProperty(lastName);
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public boolean isBusiness() {
		return isBusiness;
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}
	
	public StringProperty getFirstNameProperty() {
		return firstName;
	}
	
	public StringProperty getLastNameProperty() {
		return sirName;
	}
	
	public boolean compareTo(Guest guest){
		if(this.name == guest.getName() && this.birthday == guest.getBirthday()){
			return true;
		}
		return false;
	}
	
	

}
