package model;

import java.util.ArrayList;

public class GuestList {
	private int size;
	private ArrayList<Guest> guests;
	
	public GuestList(){
		guests = new ArrayList<Guest>();
		size = 0;
	}
	
	public void addToList(Guest guest){
		guests.add(guest);
		size++;
	}
	
	public void removeFromList(Guest guest){
		for(int i = 0; i < guests.size(); ++i){
			if(guest.compareTo(guests.get(i))){
				guests.remove(i);
			}
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean getFromList(String name, String date) {
		for(int i = 0; i < getSize(); i++) {
			if (name == guests.get(i).getName() && date == guests.get(i).getPersNum()) {
				return true;
			}
		}
		return false;
	}
	
	public Guest getGuest(int i) {
		return guests.get(i);
	}
	
	

}
