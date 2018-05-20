package model;

import java.util.ArrayList;

public class RoomList {
	
	private static ArrayList<Room> roomsVaxjo = new ArrayList<Room>();
	private static ArrayList<Room> roomsKalmar = new ArrayList<Room>();
	
	public void createRooms() {
		for(int i = 0; i < 15; i++) {
			if (i <= 10) {
				
			Room roomVaxjo = singleNormalRoom("V�xjo", i, 1, false, true);
			Room roomKalmar = singleNormalRoom("Kalmar", i, 1, false, true);
			if(i > 3) {
				roomVaxjo.setAdjoinsRoom(true);
				roomKalmar.setAdjoinsRoom(true);
			}
			roomsVaxjo.add(roomVaxjo);
			roomsKalmar.add(roomKalmar);
			}
			else if (i > 10) {
				Room roomVaxjo = singleQualityRoom("V�xj�", i, 3, true, true);
				Room roomKalmar = singleQualityRoom("V�xj�", i, 3, true, true);
				if(i > 10 && i < 13) {
					roomVaxjo.setAdjoinsRoom(true);
					roomKalmar.setAdjoinsRoom(true);
				}
				
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if (i <=6) {
				Room roomVaxjo = doubleNormalRoom("V�xj�", i, 1, false, true);
				Room roomKalmar = doubleNormalRoom("Kalmar", i, 1, false, true);
				if (i < 3) {
					roomVaxjo.setAdjoinsRoom(true);
					roomKalmar.setAdjoinsRoom(true);
				}
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else if(i > 6 && i <= 8) {
				Room roomVaxjo = doubleQualityRoom("V�xj�", i, 2, true, true);
				Room roomKalmar = doubleQualityRoom("Kalmar", i, 2, true, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else {
				Room roomVaxjo = doubleQualityRoom("V�xj�", i, 3, true, true);
				Room roomKalmar = doubleQualityRoom("Kalmar", i, 3, true, true);
				roomVaxjo.setAdjoinsRoom(true);
				roomKalmar.setAdjoinsRoom(true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
		}
		
		for (int i = 0; i < 5; i++) {
			if (i <= 3) {
				Room roomVaxjo = tripleNormalRoom("V�xj�", i, 1, false, true);
				Room roomKalmar = tripleNormalRoom("Kalmar", i, 1, false, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else if(i == 4) {
				Room roomVaxjo = tripleQualityRoom("V�xj�", i, 2, true, true);
				Room roomKalmar = tripleQualityRoom("Kalmar", i, 2, true, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else {
				Room roomVaxjo = tripleQualityRoom("V�xj�", i, 3, true, true);
				Room roomKalmar = tripleQualityRoom("Kalmar", i, 3, true, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
		}
	}
	
	public Room singleNormalRoom(String hotel, int roomNumber, int quality, boolean smoking, boolean availability) {
	Room room = new Room();
	
	room.setHotelName(hotel);
	room.setRoomNumber(roomNumber);
	room.setQuality(quality);
	room.setFloor(1);
	room.setSmokingAllowed(smoking);
	room.setAvailability(availability);
	
	
	
	return room;
	}
	
	public Room singleQualityRoom(String hotel, int roomNumber, int quality, boolean smoking, boolean availability) {
		Room room = new Room();
		
		room.setHotelName(hotel);
		room.setRoomNumber(roomNumber);
		room.setQuality(quality);
		room.setFloor(1);
		room.setSmokingAllowed(smoking);
		room.setAvailability(availability);
		
		
		return room;
	}
	
	public Room doubleNormalRoom(String hotel, int roomNumber, int quality, boolean smoking, boolean availability) {
		Room room = new Room();
		
		room.setHotelName(hotel);
		room.setRoomNumber(roomNumber);
		room.setQuality(quality);
		room.setFloor(2);
		room.setSmokingAllowed(smoking);
		room.setAvailability(availability);
		
		
		return room;
	}
	
	public Room doubleQualityRoom(String hotel, int roomNumber, int quality, boolean smoking, boolean availability) {
		Room room = new Room();
		
		room.setHotelName(hotel);
		room.setRoomNumber(roomNumber);
		room.setQuality(quality);
		room.setFloor(2);
		room.setSmokingAllowed(smoking);
		room.setAvailability(availability);
		
		
		return room;
	}
	
	public Room tripleNormalRoom(String hotel, int roomNumber, int quality, boolean smoking, boolean availability) {
		Room room = new Room();
		
		room.setHotelName(hotel);
		room.setRoomNumber(roomNumber);
		room.setQuality(quality);
		room.setFloor(3);
		room.setSmokingAllowed(smoking);
		room.setAvailability(availability);
		
		
		return room;
	}
	
	public Room tripleQualityRoom(String hotel, int roomNumber, int quality, boolean smoking, boolean availability) {
		Room room = new Room();
		
		room.setHotelName(hotel);
		room.setRoomNumber(roomNumber);
		room.setQuality(quality);
		room.setFloor(3);
		room.setSmokingAllowed(smoking);
		room.setAvailability(availability);
		
		
		return room;
	}
	
}
