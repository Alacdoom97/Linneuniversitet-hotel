package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import model.Grid;
import model.GridList;
import model.Guest;
import view.CheckInWindow;
import view.GuestWindow;
import view.RegistrationWindow;
import view.ReservationWindow;
public class ReservationController {
	CheckInWindow cheWin;
	ReservationWindow main;
	RegistrationWindow regWin;
	GuestWindow guestWin;
	int dateTrackerPrevious = 1;
	int dateTrackerNext = 1;
	private static GridList gl = new GridList();
	GridPane current;
	public ReservationController(ReservationWindow main){
		this.main = main;
		
	}
	
	public ReservationController(CheckInWindow cheWin) {
		this.cheWin = cheWin;
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
		
		main.guestButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					guestWin = new GuestWindow();
				}catch(Exception e3){
					e3.printStackTrace();
				}
			}
		});
		
		main.nextButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					main.layout.getChildren().remove(main.grid2);
					main.pane.getChildren().remove(main.monthLabel);
					main.monthDisplay(main.dateChecker.plusMonths(1));
					Grid grid = new Grid();
					grid.Grid(main.dateChecker, main.grid2);
					
					if(gl.contains(main.dateChecker) == false){
						gl.gridAdd(grid);
						System.out.println("added");
					}
					main.dateChecker = main.dateChecker.plusMonths(1);
					
					if(gl.contains(main.dateChecker)){
						main.grid2 = gl.gridGet(main.dateChecker).getGrid();
					}else{
						main.grid2 = main.newGrid();
					}
					
					
					main.layout.getChildren().add(main.grid2);
					
					
					
				}catch(Exception e4){
					e4.printStackTrace();
				}
			}
		});
		
		main.previousButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					main.layout.getChildren().remove(main.grid2);
					main.pane.getChildren().remove(main.monthLabel);
					main.monthDisplay(main.dateChecker.minusMonths(1));
					Grid grid = new Grid();
					grid.Grid(main.dateChecker, main.grid2);
					
					if(gl.contains(main.dateChecker) == false){
						gl.gridAdd(grid);
						System.out.println("added");
					}
					
					main.dateChecker = main.dateChecker.minusMonths(1);
					
					if(gl.contains(main.dateChecker)){
						main.grid2 = gl.gridGet(main.dateChecker).getGrid();
					}else{
						main.grid2 = main.newGrid();
					}
					main.layout.getChildren().add(main.grid2);
					
				}catch(Exception e5){
					e5.printStackTrace();
				}
			}
		});
		
		
	}
	
	public void checkInHandle() {
		
		
	}
	

}
