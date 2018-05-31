package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Room {
	private String hotelName;
	private int roomNumber;
	private int quality;
	private int floor;
	public static ArrayList<Booking> bookings = new ArrayList();
	private boolean smokingAllowed;
	private boolean availability;
	private boolean adjoinsRoom;
	
	public Room() {
		
	}
	
	public Room(String hotelName, int roomNumber, int quality, int floor, boolean smokingAllowed, boolean availability, boolean adjoinsRoom) {
		this.hotelName = hotelName;
		this.roomNumber = roomNumber;
		this.quality = quality;
		this.floor = floor;
		this.smokingAllowed = smokingAllowed;
		this.availability = availability;
		this.adjoinsRoom = adjoinsRoom;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isSmokingAllowed() {
		return smokingAllowed;
	}

	public void setSmokingAllowed(boolean smokingAllowed) {
		this.smokingAllowed = smokingAllowed;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public void setAdjoinsRoom(boolean setAdjoins) {
		this.adjoinsRoom = setAdjoins;
	}
	
	public boolean getAdjoinRoom(){
		return adjoinsRoom;
	}
	
	public void addBooking(Booking booking){
		bookings.add(booking);
	}
	
	public boolean bookSearch(LocalDate start, LocalDate end){
		for(int i = 0; i < bookings.size(); ++i){
			
			if((start.isAfter(bookings.get(i).getStart()) && start.isBefore(bookings.get(i).getEnd())) || (end.isBefore(bookings.get(i).getEnd())&& end.isAfter(bookings.get(i).getStart()))){
				return false;
			}
		}
		return true;
	}
	
	public boolean isBooked(LocalDate start, LocalDate end){
		for(int i = 0; i < bookings.size(); ++i){
			if(start.isAfter(bookings.get(i).getStart())&& start.isBefore(bookings.get(i).getEnd())){
				
			}
		}
		
		return false;
	}
	
	
	

}
