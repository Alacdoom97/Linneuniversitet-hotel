package main;
import view.*;
import javafx.application.Application;
import model.*;
public class Main {
	GuestList gl = new GuestList();
	
	public static void main(String[] args){
		Application.launch(MainWindow.class);
	}
}
