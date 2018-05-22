package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class RoomList {
	
	private static ArrayList<Room> roomsVaxjo = new ArrayList<Room>();
	private static ArrayList<Room> roomsKalmar = new ArrayList<Room>();
	
	public RoomList() {
		createRooms();
	}
	
	public void createRooms() {
		for(int i = 1; i <= 15; i++) {
			if (i <= 10) {
				
			Room roomVaxjo = singleNormalRoom("Växjö", i, 1, false, true);
			Room roomKalmar = singleNormalRoom("Kalmar", i, 1, false, true);
			if(i < 3) {
				roomVaxjo.setAdjoinsRoom(true);
				roomKalmar.setAdjoinsRoom(true);
			}
			roomsVaxjo.add(roomVaxjo);
			roomsKalmar.add(roomKalmar);
			}
			else if (i > 10) {
				Room roomVaxjo = singleQualityRoom("Växjö", i, 3, true, true);
				Room roomKalmar = singleQualityRoom("Växjö", i, 3, true, true);
				if(i > 10 && i < 13) {
					roomVaxjo.setAdjoinsRoom(true);
					roomKalmar.setAdjoinsRoom(true);
				}
				
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
		}
		
		for (int i = 16; i < 26; i++) {
			if (i <= 21) {
				Room roomVaxjo = doubleNormalRoom("Växjö", i, 1, false, true);
				Room roomKalmar = doubleNormalRoom("Kalmar", i, 1, false, true);
				if (i < 18) {
					roomVaxjo.setAdjoinsRoom(true);
					roomKalmar.setAdjoinsRoom(true);
				}
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else if(i > 21 && i <= 23) {
				Room roomVaxjo = doubleQualityRoom("Växjö", i, 2, true, true);
				Room roomKalmar = doubleQualityRoom("Kalmar", i, 2, true, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else {
				Room roomVaxjo = doubleQualityRoom("Växjö", i, 3, true, true);
				Room roomKalmar = doubleQualityRoom("Kalmar", i, 3, true, true);
				roomVaxjo.setAdjoinsRoom(true);
				roomKalmar.setAdjoinsRoom(true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
		}
		
		for (int i = 26; i <= 30; i++) {
			if (i <= 28) {
				Room roomVaxjo = tripleNormalRoom("Växjö", i, 1, false, true);
				Room roomKalmar = tripleNormalRoom("Kalmar", i, 1, false, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else if(i == 29) {
				Room roomVaxjo = tripleQualityRoom("Växjö", i, 2, true, true);
				Room roomKalmar = tripleQualityRoom("Kalmar", i, 2, true, true);
				roomsVaxjo.add(roomVaxjo);
				roomsKalmar.add(roomKalmar);
			}
			else {
				Room roomVaxjo = tripleQualityRoom("Växjö", i, 3, true, true);
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
	
	public ArrayList<Room> roomSearchV(int quality, int bed, boolean adjoin, LocalDate start, LocalDate end){
		ArrayList<Room> tempRoomList = new ArrayList<Room>();
		ArrayList<Room> temp2 = new ArrayList<Room>();
		for(int i= 0; i < roomsVaxjo.size(); ++i){

			if(quality == roomsVaxjo.get(i).getQuality() && bed == roomsVaxjo.get(i).getFloor() && adjoin == roomsVaxjo.get(i).getAdjoinRoom() && roomsVaxjo.get(i).bookSearch(start, end)){
				tempRoomList.add(roomsVaxjo.get(i));
				
				

			if(quality == roomsVaxjo.get(i).getQuality() && bed == roomsVaxjo.get(i).getFloor() && adjoin == roomsVaxjo.get(i).getAdjoinRoom() && roomsVaxjo.get(i).isAvailability()){
				//for(int j = 0; j < roomsVaxjo.get(i).bookings.size(); ++j){
					//if((start.isAfter(roomsVaxjo.get(i).bookings.get(j).getStart()) && start.isBefore(roomsVaxjo.get(i).bookings.get(j).getEnd())) || (end.isAfter(roomsVaxjo.get(i).bookings.get(j).getStart()) && end.isBefore(roomsVaxjo.get(i).bookings.get(j).getEnd())) ){
					System.out.println("room is Available");
					tempRoomList.add(roomsVaxjo.get(i));
					}
				else{
						System.out.println(roomsVaxjo.get(i).getRoomNumber());
						
						
					}
				//}

				
			}
		
		
		
		
		return temp2;
	
	}
	
	public Room getRoom(int i){
		return roomsVaxjo.get(i);
	}
	
}
