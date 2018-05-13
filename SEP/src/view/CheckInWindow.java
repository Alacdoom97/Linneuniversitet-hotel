package view;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Guest;
import model.GuestList;

public class CheckInWindow {
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public static final ObservableList<Guest> names = FXCollections.observableArrayList();
	public Button checkIn = new Button();
	public Button checkOut = new Button();
	public Stage guestWin = new Stage();
	private GuestList gueList = new GuestList();
	GridPane gridy;
	LocalDate now = LocalDate.now();

	public CheckInWindow() {
		cheWin();

	}

	@SuppressWarnings("unchecked")
	public void cheWin() {
		Pane pane = new Pane();
		gridy = new GridPane();
		gridy.setAlignment(Pos.CENTER);
		gridy.setPadding(new Insets(40, 40, 40, 40));
		gridy.setGridLinesVisible(false);
		gridy.setTranslateX(200);
		gridy.setTranslateY(50);

		checkIn.setText("Check In");
		checkIn.setPrefSize(120, 120);
		checkIn.setTranslateX(125);
		checkIn.setTranslateY(300);

		checkOut.setText("Check Out");
		checkOut.setPrefSize(120, 120);
		checkOut.setTranslateX(275);
		checkOut.setTranslateY(300);

		for (int i = 0; i < 1; i++) {
			/* Creating the Columns and rows */
			ColumnConstraints columns = new ColumnConstraints();
			columns.setPercentWidth(250 / 3);
			gridy.getColumnConstraints().add(columns);

		}
		for (int i = 0; i < 5; i++) {
			/* Creating the Columns and rows */

			RowConstraints rows = new RowConstraints();
			rows.setPercentHeight(250 / 5);
			gridy.getRowConstraints().add(rows);
		}

		final ListView listView = new ListView<>(names);

		listView.setPrefSize(250, 450);
		listView.setEditable(true);

		Guest guest1 = new Guest("", "Alfred", "Mourney", "Georg Lückligs Väg 22", now, false);
		Guest guest2 = new Guest("", "Hau", "Trinh", "Lovely Street 29", now, false);
		Guest guest3 = new Guest("", "Pranav", "Patel", "Näktergalsvägen 30", now, false);
		Guest guest4 = new Guest("", "Stefan", "Bampovits", "Stuborvägen 15", now, false);
		Guest guest5 = new Guest("", "Vikrant", "Mainali", "Fyllerydsvägen 43C", now, false);
		Guest guest6 = new Guest("", "Christian", "Fagerholm", "Kungsgatan 13", now, false);

		names.add(guest1);
		names.add(guest2);
		names.add(guest3);
		names.add(guest4);
		names.add(guest5);
		names.add(guest6);
		
		
		gueList.addToList(guest1);
		gueList.addToList(guest2);
		gueList.addToList(guest3);
		gueList.addToList(guest4);
		gueList.addToList(guest5);
		gueList.addToList(guest6);

		for (int i = 0; i < names.size(); i++) {
			data.add(names.get(i).getName() + " " + names.get(i).getLastName());
		}

		listView.setItems(data);

		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				if (event.getButton().equals(MouseButton.PRIMARY)) {
					if (event.getClickCount() == 2) {
						for (int i = 0; i < gueList.getSize(); i++) {
							if (names.get(i) == null) {
								Guest guest = names.get(i);
								if (guest != null) {
									Pane listPane = new Pane();
									Scene listScene = new Scene(listPane, 500, 500);
									Stage listStage = new Stage();

									Label nameLab = new Label("Name: ");
									nameLab.setTranslateY(10);

									TextField name = new TextField(guest.getName());
									name.setEditable(false);
									name.setTranslateX(60);
									name.setTranslateY(10);

									Label lastNameLab = new Label("Last Name: ");
									lastNameLab.setTranslateY(40);

									TextField lastName = new TextField(guest.getLastName());
									lastName.setEditable(false);
									lastName.setTranslateX(60);
									lastName.setTranslateY(40);

									Label addressLab = new Label("Address: ");
									addressLab.setTranslateY(70);

									TextField address = new TextField(guest.getAdress());
									address.setEditable(false);
									address.setTranslateY(70);
									address.setTranslateX(60);

									Label birthdayLab = new Label("Birthday: ");
									birthdayLab.setTranslateY(100);

									TextField birthday = new TextField(guest.getBirthday().toString());
									birthday.setEditable(false);
									birthday.setTranslateY(100);
									birthday.setTranslateX(60);

									Label businessLab = new Label("Business stay: ");
									businessLab.setTranslateY(130);

									TextField isBusiness = new TextField(guest.booleanToString(guest.isBusiness()));
									isBusiness.setEditable(false);
									isBusiness.setTranslateY(130);
									isBusiness.setTranslateX(80);

									listPane.getChildren().addAll(name, nameLab, lastName, lastNameLab, address,
											addressLab, birthday, birthdayLab, isBusiness, businessLab, checkIn,
											checkOut);
									listStage.setScene(listScene);
									listStage.show();
								}
							}

						}
					}
				}
			}
		});

		StackPane root = new StackPane();
		pane.getChildren().addAll(root, gridy);
		root.getChildren().addAll(listView);

		Scene scene = new Scene(pane, 500, 500);
		guestWin.setScene(scene);
		guestWin.show();
	}
}
