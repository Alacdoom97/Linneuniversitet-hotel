package model;

public class Room {
	private int roomNumber;
	private int quality;
	private int floor;
	private boolean smokingAllowed;
	private boolean availability;
	
	public Room() {
		
	}
	
	public Room(int roomNumber, int quality, int floor, boolean smokingAllowed, boolean availability) {
		this.roomNumber = roomNumber;
		this.quality = quality;
		this.floor = floor;
		this.smokingAllowed = smokingAllowed;
		this.availability = availability;
	}

}
