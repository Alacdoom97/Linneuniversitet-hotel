package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Guest;
import model.GuestList;

public class GuestTest {

	@Test
	public void test() {
		GuestList gl = new GuestList();
		int i = 1;
		boolean bol = false;
		Guest guest = new Guest(i,"haha","haha","haha","111","haha", bol);
		Guest guest1 = new Guest(i,"haha","haha","haha","111","haha", bol);
		
		if(!gl.getFromList(guest.getName(), guest.getPersNum())){
			gl.addToList(guest);
		}
		
		
		
		
		
		assertTrue(gl.getFromList(guest1.getName(), guest1.getPersNum()));
	}

}
