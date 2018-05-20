package model;

import java.time.LocalDate;

public class Booking {
	LocalDate start;
	LocalDate end;
	Guest guest;

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public Guest getGuest() {
		return guest;
	}

}
