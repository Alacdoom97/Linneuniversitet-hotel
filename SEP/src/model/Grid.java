package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class Grid {
	public LocalDate date;
	GridPane gp;
	
	public void Grid(LocalDate date, GridPane gp){
		this.date = date;
		this.gp = gp;
		
	}
	
	public GridPane getGrid(){
		return gp;
	}
	
	public LocalDate getDate(){
		return date;
	}

}
