package controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import view.CheckinWindow;
import view.MainWindow;
import view.RegistrationWindow;
import view.ReservationWindow;
public class MainWindowController {
	
	RegistrationWindow regWin;
	ReservationWindow resWin;
	CheckinWindow cheWin;
	MainWindow main;
	
	public MainWindowController(MainWindow main){
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
		
		
	}
	

}
