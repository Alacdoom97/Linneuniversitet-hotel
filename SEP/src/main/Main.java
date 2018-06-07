package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import controller.ReservationController;
import database.SQLConnection;
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
		SQLConnection sq = new SQLConnection();
		String query = "SELECT * from GuestList";
		ResultSet rs = sq.importData(query);

		try {
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String companyName = rs.getString("companyName");
				String firstName = rs.getString("name");
				String lastName = rs.getString("lastname");
				String address = rs.getString("adress");
				String phoneNumber = rs.getString("phoneNumber");
				String birthday = rs.getString("dateOfBirth");
				Boolean isBusiness = rs.getBoolean("businessCheck");
				Guest guest = new Guest(ID, companyName, firstName, lastName, address, phoneNumber, birthday,
						isBusiness, false);

				gl.addToList(guest);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sq.DBDisconnector();
		
		
		
		Application.launch(MainWindow.class);
		
		
		
		
	}
}
