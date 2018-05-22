package model;

import java.util.ArrayList;

public class BookingList {
	
	ArrayList<Booking> bookings = new ArrayList<Booking>();
	public BookingList(){
		
	}
	
	public void addBooking(Booking booking){
		bookings.add(booking);
	}
	
	public int size(){
		return bookings.size();
	}
	
	public Booking getBooking(int i){
		return bookings.get(i);
	}

}
