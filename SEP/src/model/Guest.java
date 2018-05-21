package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Guest {
	private int ID;
	private String companyName = null;
	private String name;
	private String lastName;
	private String adress;
	private String phoneNumber;
	private String personalNumber;
	private Booking booking = null;
	private String checkinTime;
	private String checkoutTime;
	private boolean isBusiness;
	private boolean isCheckedIn;
	
	public Guest() {
		
	}
	
	public Guest(int ID, String company, String name, String lastName, String address, String phoneNumber, String personalNumber, boolean isBusiness, boolean isCheckin){
		this.ID = ID;
		this.companyName = company;
		this.name = name;
		this.lastName = lastName;
		this.adress = address;
		this.phoneNumber = phoneNumber;
		this.personalNumber = personalNumber;
		this.isBusiness = isBusiness;
		this.isCheckedIn = isCheckedIn;
	}
	
	
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
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
	
	public void setPhone(String phone){
		this.phoneNumber = phone;
	}
	
	public String getPhone(){
		return phoneNumber;
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
	
	public boolean getCheckIn() {
		return isCheckedIn;
	}
	
	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
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
	
	public void setCheckInTime(LocalDate time){
		checkinTime = time.toString();
	}
	
	public void setCheckOutTime(LocalDate time){
		checkoutTime = time.toString();
	}
	
	public String getCheckInTime(){
		return checkinTime;
	}
	
	public String getCheckOutTime(){
		return checkoutTime;
	}
	
	public String idToString(int ID) {
		return Integer.toString(ID);
	}
	
	public void setBooking(Booking booking){
		this.booking = booking;
	}
	
	public Booking getBooking(){
		return booking;
	}
	

}
