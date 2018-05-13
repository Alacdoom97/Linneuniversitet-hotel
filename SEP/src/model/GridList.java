package model;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Grid;

public class GridList {
	ArrayList<Grid> gridList = new ArrayList<Grid>();
	int size = 0;
	
	public void gridAdd(Grid grid){
		gridList.add(grid);
		++size;
	}
	
	public Grid gridGet(LocalDate date){
		for(int i = 0; i < gridList.size(); ++i){
			if(date.isEqual(gridList.get(i).getDate())){
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
			if(gridList.get(i).getDate().isEqual(date)){
				return true;
			}
		}
		return false;
	}

}