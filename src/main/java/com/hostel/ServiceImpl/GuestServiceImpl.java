package com.hostel.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hostel.Dao.GuestRepo;
import com.hostel.Dao.RoomRepo;
import com.hostel.Entities.Guest;
import com.hostel.Entities.Room;
import com.hostel.Service.GuestService;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestRepo guestRepo;
	
	@Autowired
	RoomRepo roomRepo;
	
	@Override
	public Guest getGuest(Integer id) {
		Guest foundGuest = guestRepo.findById(id).orElse(null);
		return foundGuest;
	}

	@Override
	public List<Guest> getAllGuests() {
		List<Guest> allGuests = guestRepo.findAll();
		return allGuests;
	}

	@Override
	public Guest saveGuest(Guest guest) {
		int roomId = guest.getRoomId();
		if(roomId>0) {
			Room room = roomRepo.findById(guest.getRoomId()).orElse(null);
			if(room!=null) {
				guest.setRoom(room);
			}else {
				
				return null;
			}	
		}
		return guestRepo.save(guest);
	}

	@Override 
	public List<Guest> saveAllGuests(List<Guest> guests) {
		List<Guest> savedGuests = guestRepo.saveAll(guests);
		return savedGuests;
	}

	@Override
	public void deleteGuest(Integer id) {
		guestRepo.deleteById(id);
	}
	
	@Override
	public void deleteAllGuests(List<Guest> guests) {
		guestRepo.deleteAll(guests);
	}


	@Override
	public Guest updateGuest(Guest guest) {
		Guest existingGuest = guestRepo.findById(guest.getGid()).orElse(null);
		if(existingGuest != null) {
			existingGuest.setFirstName(guest.getFirstName());
			existingGuest.setLastName(guest.getLastName());
			existingGuest.setMobileNo(guest.getMobileNo());
			existingGuest.setAdharNumber(guest.getAdharNumber());
			existingGuest.setAge(guest.getAge());
			Room room = roomRepo.findById(guest.getRoomId()).orElse(null);
			if(room!=null) {
				existingGuest.setRoom(room);
				return guestRepo.save(existingGuest);
			}
		}
		return null;
	}

	


}
