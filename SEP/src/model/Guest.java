package model;

import java.time.LocalDate;

public class Guest {
	private String companyName;
	private String name;
	private String lastName;
	private String adress;
	private String personalNumber;
	private boolean isBusiness;
	
	public Guest(){
		createGuest("", "", "", "", false);
	}
	public Guest(String company, String name, String lastName, String address, String personalNumber, boolean isBusiness){
		companyName = company;
		this.name = name;
		this.lastName = lastName;
		this.adress = address;
		this.personalNumber = personalNumber;
		this.isBusiness = isBusiness;
	}
	
	public void createGuest(String name, String lastname, String adress, String personalNumber, boolean isBusiness){
		
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
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPersNum() {
		return personalNumber;
	}

	public void setBirthday(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public boolean isBusiness() {
		return isBusiness;
	}
	
	public String booleanToString(boolean bool) {
		if(bool == true) {
			return "Yes";
		}
		else {
			return "No";
		}
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}
	
	public boolean compareTo(Guest guest){
		if(this.name == guest.getName() && this.personalNumber == guest.getPersNum() 
				&& this.isBusiness == guest.isBusiness() & this.lastName == guest.getLastName()){
			return true;
		}
		else {
		return false;
		}
	}
	
	

}
