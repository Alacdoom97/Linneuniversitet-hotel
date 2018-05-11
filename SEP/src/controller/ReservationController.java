package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.*;
public class ReservationController {
	ReservationWindow main;
	RegistrationWindow regWin;
	public ReservationController(ReservationWindow main){
		this.main = main;
		
	}
	
	public void eventHandle(){
		main.newGuestButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					regWin=new RegistrationWindow();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		
		main.cancelB.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					main.resWin.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
	}
	

}
