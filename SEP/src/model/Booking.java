package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
	ArrayList<Booking> bookings;
	LocalDate start;
	LocalDate end;
	Guest guest;
	Room room;
	
	public Booking(LocalDate start, LocalDate end, Guest guest, Room room) {
		this.start = start;
		this.end = end;
		this.guest = guest;
		this.room = room;
	}
	
	public Booking(){
		
	}
	
	

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public Guest getGuest() {
		return guest;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}

}
