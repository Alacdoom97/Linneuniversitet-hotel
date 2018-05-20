package main;
import view.*;
import javafx.application.Application;
import model.*;
public class Main {
	public GuestList gl = new GuestList();
	public RoomList rl = new RoomList();
	
	public static void main(String[] args){
		Application.launch(MainWindow.class);
		ReservationController(this);
		
	}
}
