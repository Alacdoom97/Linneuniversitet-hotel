package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Guest;

public class CheckinWindow {
			
	@FXML
	private TextField filterField;
	@FXML
	private TableView<Guest> GuestTable;
	@FXML
	private TableColumn<Guest, String> firstNameColumn;
	@FXML
	private TableColumn<Guest, String> lastNameColumn;
    private ObservableList<Guest> masterData = FXCollections.observableArrayList();
	public CheckinWindow() {
		checkIn();
	}
	
	public void checkIn() {
		Stage CheckWindow = new Stage();
		Group checkGroup = new Group();
		
		 masterData.add(new Guest("IKEA", "Hans", "Muster", "Kontrolgatan 7", null, true));
	     masterData.add(new Guest("Astra Zeneca", "Ruth", "Mueller", "Mindgatan 13", null, true));
	     masterData.add(new Guest("Sony", "Heinz", "Kurz", "Ringgatan 59B", null, true));
	     masterData.add(new Guest("", "Cornelia", "Meier", "Lindeborgsgatan 14", null, false));
	     masterData.add(new Guest("", "Werner", "Meyer", "Dirigentsgatan 1", null, false));
	     masterData.add(new Guest("Apple", "Lydia", "Kunz", "Kungvägen 2", null, true));
	     masterData.add(new Guest("", "Anna", "Best", "Kärleksgatan 12", null, false));
	     masterData.add(new Guest("Yayo inc.", "Stefan", "Bampovits", "Fuck you up gatan 69", null, true));
	     masterData.add(new Guest("Tesla", "Martin", "Mueller", "Royal Street 5", null, true));
		    /**
		     * Just add some sample data in the constructor.
		     */
	     firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
	        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());

	        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
	        FilteredList<Guest> filteredData = new FilteredList<>(masterData, p -> true);

	        // 2. Set the filter Predicate whenever the filter changes.
	        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(Guest -> {
	                // If filter text is empty, display all Guests.
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                // Compare first name and last name of every Guest with filter text.
	                String lowerCaseFilter = newValue.toLowerCase();

	                if (Guest.getName().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } else if (Guest.getLastName().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                }
	                return false; // Does not match.
	            });
	        });

	        // 3. Wrap the FilteredList in a SortedList. 
	        SortedList<Guest> sortedData = new SortedList<>(filteredData);

	        // 4. Bind the SortedList comparator to the TableView comparator.
	        sortedData.comparatorProperty().bind(GuestTable.comparatorProperty());

	        // 5. Add sorted (and filtered) data to the table.
	        GuestTable.setItems(sortedData);
		       
	        checkGroup.getChildren().add(GuestTable);
	        Scene checkScene = new Scene(checkGroup, 500, 500);
		    CheckWindow.setScene(checkScene);
		    CheckWindow.show();

		    /**
		     * Initializes the controller class. This method is automatically called
		     * after the fxml file has been loaded.
		     * 
		     * Initializes the table columns and sets up sorting and filtering.
		     */
		    
	}
}
