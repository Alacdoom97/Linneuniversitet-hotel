package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import main.Main;
import model.Booking;
import model.Grid;
import model.GridList;
import model.Guest;
import model.Room;
import view.CheckInWindow;
import view.ErrorWindow;
import view.GuestWindow;
import view.MainWindow;
import view.RegistrationWindow;
import view.ReservationWindow;

public class ReservationController {
	CheckInWindow cheWin;
	ReservationWindow main;
	RegistrationWindow regWin;
	GuestWindow guestWin;
	ErrorWindow errWin = new ErrorWindow();
	Main program;
	MainController mainControl = new MainController(new MainWindow());
	int dateTrackerPrevious = 1;
	int dateTrackerNext = 1;
	private static GridList gl = new GridList();
	private Grid grid;
	GridPane current;
	static Guest currentG = null;
	private LocalDate arrival;
	private LocalDate departure;
	public static ArrayList<Room> temp;
	int quality;
	boolean adjoinment;
	int roomtype;
	private static Room tempRoom = null;
	
	public ReservationController(ReservationWindow main) {
		this.main = main;

	}

	public ReservationController(CheckInWindow cheWin) {
		this.cheWin = cheWin;
	}

	public ReservationController(GuestWindow gueWin) {
		this.guestWin = gueWin;
	}

	public ReservationController(Main program) {
		this.program = program;
	}

	public void eventHandle() {
		main.newGuestButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					regWin = new RegistrationWindow();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		main.cancelB.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					main.resWin.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		main.guestButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					guestWin = new GuestWindow();

					guestInputHandle();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});

		main.nextButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					main.layout.getChildren().remove(main.grid2);
					main.pane.getChildren().remove(main.monthLabel);
					main.monthDisplay(main.dateChecker.plusMonths(1));
					grid = new Grid();
					grid.Grid(main.dateChecker, main.grid2);

					if (gl.contains(main.dateChecker) == false) {
						gl.gridAdd(grid);
						System.out.println("added");
					}
					main.dateChecker = main.dateChecker.plusMonths(1);

					if (gl.contains(main.dateChecker)) {
						main.grid2 = gl.gridGet(main.dateChecker).getGrid();
					} else {
						main.grid2 = main.newGrid();
						main.gridFill(main.grid2);
					}

					main.layout.getChildren().add(main.grid2);

				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});

		main.previousButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {

					main.layout.getChildren().remove(main.grid2);
					main.pane.getChildren().remove(main.monthLabel);
					main.monthDisplay(main.dateChecker.minusMonths(1));
					Grid grid = new Grid();
					grid.Grid(main.dateChecker, main.grid2);

					if (gl.contains(main.dateChecker) == false) {
						gl.gridAdd(grid);
						System.out.println("added");
					}

					main.dateChecker = main.dateChecker.minusMonths(1);

					if (gl.contains(main.dateChecker)) {
						main.grid2 = gl.gridGet(main.dateChecker).getGrid();
					} else {
						main.grid2 = main.newGrid();
						main.gridFill(main.grid2);
					}
					main.layout.getChildren().add(main.grid2);

				} catch (Exception e5) {
					e5.printStackTrace();
				}
			}
		});

		main.searchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					if (main.cBoxBeds.getValue() == "Single Room") {
						roomtype = 1;
					} else if (main.cBoxBeds.getValue() == "Double Room") {
						roomtype = 2;
					} else if (main.cBoxBeds.getValue() == "Triple Room") {
						roomtype = 3;
					}

					if (main.cBoxQuality.getValue() == "1-Star") {
						quality = 1;
					} else if (main.cBoxQuality.getValue() == "2-Star") {
						quality = 2;
					} else if (main.cBoxQuality.getValue() == "3-Star") {
						quality = 3;
					}

					if (main.adjoinment.getValue().equals("Adjoining")) {
						adjoinment = true;
					} else {
						adjoinment = false;
					}

					arrival = main.checkInDate.getValue();
					departure = main.checkOutDate.getValue();

					temp = Main.rl.roomSearchV(quality, roomtype, adjoinment, arrival, departure);
					

					ArrayList<Room> temp = program.rl.roomSearchV(quality, roomtype, adjoinment, arrival, departure);
					
					main.searchButtonActivate();
					
					
				} catch (Exception e6) {

					e6.printStackTrace();
				}

			}

		});
		
		main.confirmRoom.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent confirmRoom) {
				
				for (int i = 0; i < main.roomsList.size(); i++) {
					if (main.roomSearch.getValue().toString()
							.equals(Integer.toString(main.roomsList.get(i).getRoomNumber()))) {
						tempRoom = main.roomsList.get(i);
					}
				}
				if (arrival.toString().isEmpty() || departure.toString().isEmpty() || currentG == null || tempRoom == null) {
					System.out.println(tempRoom.getRoomNumber());
					errWin.reservationError();
				}
				else {
				Booking booking = new Booking(arrival, departure, currentG, tempRoom);
				tempRoom.addBooking(booking);
				program.bl.addBooking(booking);
				
				main.reDraw(program.bl);
				main.roomSearchStage.close();
				}
				
			}
		});
	}

	public void guestInputHandle() {

		guestWin.searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					ArrayList<Guest> tempList = new ArrayList<Guest>();
					for (int i = 0; i < cheWin.names.size(); i++) {
						Guest guest = cheWin.names.get(i);
						if (cheWin.searchBar.getText().equals(guest.getName())
								&& cheWin.searchBar2.getText().equals(guest.getPersNum())) {
							
							tempList.add(guest);
						}
					}

					for (int i = 0; i < tempList.size(); i++) {
						cheWin.data.add(tempList.get(i).getName() + " " + tempList.get(i).getLastName());
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
				
				for (int i = 0; i < cheWin.names.size(); i++) {
					if (guestWin.listView.getSelectionModel().getSelectedItem()
							.equals(cheWin.names.get(i).getName() + " " + cheWin.names.get(i).getLastName())) {
						currentG = cheWin.names.get(i);
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
