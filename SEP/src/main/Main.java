package main;
import view.*;
import controller.ReservationController;
import javafx.application.Application;
import model.*;
public class Main {
	public GuestList gl = new GuestList();
	public RoomList rl = new RoomList();
	ReservationController rc = new ReservationController(this);
	public static void main(String[] args){
		Application.launch(MainWindow.class);
		
		
	}
}
