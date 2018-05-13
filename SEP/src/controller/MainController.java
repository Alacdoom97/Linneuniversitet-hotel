package controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.CheckInWindow;
import view.GuestWindow;
import view.MainWindow;
import view.RegistrationWindow;
import view.ReservationWindow;
public class MainController {
	
	CheckInWindow cheWin;
	RegistrationWindow regWin;
	ReservationWindow resWin;
	GuestWindow gueWin;
	MainWindow main;
	
	public MainController(MainWindow main){
		this.main = main;
	}
	
	public void eventHandle(){
		main.guestButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					regWin=new RegistrationWindow();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		main.reservationButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent e){
				try{
					resWin = new ReservationWindow();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		main.guestListButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					gueWin = new GuestWindow();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		
		main.checkinButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					cheWin = new CheckInWindow();
				} catch(Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		
	}
	

}
