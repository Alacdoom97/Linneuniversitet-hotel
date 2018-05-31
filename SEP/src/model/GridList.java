package model;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.Grid;

public class GridList {
	GridPane temp;
	Grid tempGrid;
	ArrayList<Grid> gridList = new ArrayList<Grid>();
	int size = 0;
	
	public void gridAdd(Grid grid){
		gridList.add(grid);
		++size;
	}
	
	public Grid gridGet(LocalDate date){
		for(int i = 0; i < gridList.size(); ++i){
			if(gridList.get(i).getDate().getMonthValue() == date.getMonthValue() && gridList.get(i).getDate().getYear() == date.getYear()){
				return gridList.get(i);
				}
			}
		return null;
		
		
		
	}
	
	public Grid get(int i){
		return gridList.get(i);
	}
	
	public int size(){
		return size;
		
	}
	
	public boolean contains(LocalDate date){
		for(int i = 0; i < gridList.size(); ++i){
			if(gridList.get(i).getDate().getMonth().equals(date.getMonth()) && gridList.get(i).getDate().getYear() == date.getYear()){
				return true;
			}
		}
		
		return false;
	}
	
	public void createNewYear(LocalDate date){
		date = date.minusDays(date.getDayOfMonth()-1);
		date = date.minusMonths(date.getMonthValue()-1);
		System.out.println(date);
		
		for(int i = 0; i < 12; ++i){
			temp = newGrid();
			gridFill(temp);
			tempGrid = new Grid(date, temp);
			gridList.add(tempGrid);
			date = date.plusMonths(1);
		}
	}
	
	public GridPane newGrid(){
		GridPane newGp = new GridPane();
		newGp.setGridLinesVisible(true);
		newGp.setPrefSize(1000, 625);
		newGp.setStyle("-fx-background-color:grey");
		newGp.setTranslateX(99);
		newGp.setTranslateY(230);
		
		int rowMax2 = 31;
		int colMax2 = 31;
		
		for (int i = 0; i < rowMax2; ++i){
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0/rowMax2);
			newGp.getRowConstraints().add(rowConst);
		}
		
		for(int i = 0; i < colMax2; ++i){
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0/colMax2);
			newGp.getColumnConstraints().add(colConst);
		}
		
		
		
		return newGp;
	}
	
	public void gridFill(GridPane grid){
		for(int i = 0; i < 31; ++i){
			grid.add(textLabel(Integer.toString(i+1)), i, 0);
		}
		
		
		
	}
	
	public Label textLabel(String text){
		Label tl = new Label(text);
		return tl;
	}
	
	

}