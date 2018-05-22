package main;

import java.time.LocalDate;

import controller.ReservationController;
import javafx.application.Application;
import model.Booking;
import model.BookingList;
import model.Guest;
import model.GuestList;
import model.RoomList;
import view.MainWindow;

public class Main {
	public static GuestList gl = new GuestList();

	public static RoomList rl = new RoomList();
	


	
	
	public static BookingList bl = new BookingList();
	
	ReservationController rc = new ReservationController(this);

	ReservationController resControl = new ReservationController(this);
	

	public static void main(String[] args){
		Guest g1 = new Guest(1, "McDonalds", "Hau", "Trinh", "Furutåvägen","hhahaha", "1993-04-01", true, false);
		Booking bookings = new Booking(LocalDate.now(),LocalDate.now().plusDays(6),g1,rl.getRoom(9));
		
		rl.getRoom(9).bookings.add(bookings);
		System.out.println(rl.getRoom(9).bookings.get(0).getStart()+" "+ rl.getRoom(9).bookings.get(0).getEnd());
		
		Application.launch(MainWindow.class);
		
		
		
		
	}
}
