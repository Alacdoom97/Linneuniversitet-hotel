package controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.Main;
import model.GuestList;
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
	public static GuestList gl = new GuestList();
	
	public MainController(MainWindow main){
		this.main = main;
	}
	
	public void eventHandle(){
		main.guestButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					regWin=new RegistrationWindow();
					
					main.guestButton.disableProperty().bind(regWin.regWin.showingProperty());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		main.reservationButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle (ActionEvent e){
				try{
					resWin = new ReservationWindow();
					Main mainclass = new Main();
					
					main.reservationButton.disableProperty().bind(resWin.resWin.showingProperty());
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		
		
		main.checkinButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					cheWin = new CheckInWindow();
					
					main.checkinButton.disableProperty().bind(cheWin.guestWin.showingProperty());
				} catch(Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		
	}
	

}
