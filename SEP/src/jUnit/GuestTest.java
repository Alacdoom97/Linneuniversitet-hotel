package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Guest;
import model.GuestList;

public class GuestTest {

	@Test
	public void CreateGuest() {
		
		Guest g1 = new Guest(1, "McDonalds", "Hau", "Trinh", "Furutåvägen","hhahaha", "1993-04-01", true);
		Guest g2 = new Guest(2, "Burger King", "Pranav", "Patel", "Smultronvägen","hhahaha", "1997-11-25", true);
		Guest g3 = new Guest(3, "MAX", "Vikrant", "Mainali", "Blåbärsvägen","hhahaha", "1998-12-03", true);
		
		assertEquals(1, g1.getID());
		assertEquals("McDonalds", g1.getCompanyName()); 
		assertEquals("Hau", g1.getName());
		assertEquals("Trinh", g1.getLastName());
		assertEquals("Furutåvägen", g1.getAdress());
		assertEquals("1993-04-01", g1.getPersNum());
		
		assertEquals(2, g2.getID());
		assertEquals("Burger King", g2.getCompanyName());
		assertEquals("Pranav", g2.getName());
		assertEquals("Patel", g2.getLastName());
		assertEquals("Smultronvägen", g2.getAdress());
		assertEquals("1997-11-25", g2.getPersNum());
		
		assertEquals(3, g3.getID());
		assertEquals("MAX", g3.getCompanyName());
		assertEquals("Vikrant", g3.getName());
		assertEquals("Mainali", g3.getLastName());
		assertEquals("Blåbärsvägen", g3.getAdress());
		assertEquals("1998-12-03", g3.getPersNum());
	}
	
	@Test
	public void addGuest(){
		
		Guest g1 = new Guest(1, "McDonalds", "Hau", "Trinh", "Furutåvägen","hhahaha", "1993-04-01", true);
		Guest g2 = new Guest(2, "Burger King", "Pranav", "Patel", "Smultronvägen","hhahaha", "1997-11-25", true);
		Guest g3 = new Guest(3, "MAX", "Vikrant", "Mainali", "Blåbärsvägen","hhahaha", "1998-12-03", true);
		
		GuestList gl = new GuestList();
		
		gl.addToList(g1);
		gl.addToList(g2);
		gl.addToList(g3);
		
		assertEquals(3, gl.getSize());
	}

}
