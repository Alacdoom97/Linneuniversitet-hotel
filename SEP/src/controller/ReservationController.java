package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Grid;
import model.GridList;
import model.Guest;
import view.CheckInWindow;
import view.GuestWindow;
import view.MainWindow;
import view.RegistrationWindow;
import view.ReservationWindow;
public class ReservationController {
	CheckInWindow cheWin;
	ReservationWindow main;
	RegistrationWindow regWin;
	GuestWindow guestWin;
	MainController mainControl = new MainController(new MainWindow());
	int dateTrackerPrevious = 1;
	int dateTrackerNext = 1;
	private static GridList gl = new GridList();
	GridPane current;
	Guest currentG;
	public ReservationController(ReservationWindow main){
		this.main = main;
		
	}
	
	public ReservationController(CheckInWindow cheWin) {
		this.cheWin = cheWin;
	}
	
	public ReservationController(GuestWindow gueWin) {
		this.guestWin = gueWin;
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
					
					guestInputHandle();
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
	
	public void guestInputHandle() {
		
		guestWin.searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					guestWin.names.clear();
					guestWin.data.clear();
					for (int i = 0; i < mainControl.gl.getSize(); i++) {
						Guest guest = mainControl.gl.getGuest(i);
						if (guestWin.searchBar.getText().equals(guest.getName())
								&& guestWin.searchBar2.getText().equals(guest.getPersNum())) {
							guestWin.names.add(guest);
						}
					}

					for (int i = 0; i < guestWin.names.size(); i++) {
						guestWin.data.add(guestWin.names.get(i).idToString(guestWin.names.get(i).getID()) + " " + guestWin.names.get(i).getName() 
								+ " " + guestWin.names.get(i).getLastName());
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
				
			}
		});
		guestWin.listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent listGuest) {
				main.name.setText("");
				main.birthday.setText("");
				main.address.setText("");
					Guest currentG = null;
					for (int i = 0; i < guestWin.names.size(); i++) {
						if (guestWin.listView.getSelectionModel().getSelectedItem()
								.equals(guestWin.names.get(i).idToString(guestWin.names.get(i).getID()) + " " + guestWin.names.get(i).getName() + " "
										+ guestWin.names.get(i).getLastName())) {
							currentG = guestWin.names.get(i);
						}
					}
					System.out.println("haha");
					System.out.println(currentG.getName());
					if (currentG != null) {
						main.name.setText(currentG.getName());
						main.birthday.setText(currentG.getPersNum());
						main.address.setText(currentG.getAdress());
						main.phone.setText(currentG.getPhone());
					
					}
				
			}
			
		});
	}
	

}
