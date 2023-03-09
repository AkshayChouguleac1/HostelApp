package com.hostel.Service;

import java.util.List;

import com.hostel.Entities.Guest;

public interface GuestService {
	public Guest getGuest(Integer id);
	public List<Guest> getAllGuests();
	public Guest saveGuest(Guest guest);
	public List<Guest> saveAllGuests(List<Guest> guests);
	public void deleteGuest(Integer id);
	public void deleteAllGuests(List<Guest> guests);
	public Guest updateGuest(Guest guest);

}
