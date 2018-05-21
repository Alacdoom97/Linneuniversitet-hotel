package main;

import view.*;

import controller.ReservationController;
import javafx.application.Application;
import model.GuestList;
import model.RoomList;
import view.MainWindow;
public class Main {
	public GuestList gl = new GuestList();
	public RoomList rl = new RoomList();

	ReservationController rc = new ReservationController(this);

	ReservationController resControl = new ReservationController(this);
	

	public static void main(String[] args){
		Application.launch(MainWindow.class);
		
		
	}
}
