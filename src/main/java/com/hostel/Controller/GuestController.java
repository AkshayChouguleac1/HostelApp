package com.hostel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.Dao.RoomRepo;
import com.hostel.Entities.Guest;
import com.hostel.Entities.Room;
import com.hostel.Service.GuestService;
import com.hostel.Service.RoomService;
@RestController
@RequestMapping(value = "/Guests")
public class GuestController {
	
	@Autowired
	GuestService guestService;
	
	@Autowired
	RoomService roomService;
	
	@GetMapping(value = "/getGuest/{id}")
	public ResponseEntity<Guest> getGuest(@PathVariable(name = "id") int id){
		return new ResponseEntity<Guest>(guestService.getGuest(id),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllGuests")
	public ResponseEntity<List<Guest>> getAllGuests(){
		return new ResponseEntity<List<Guest>>(guestService.getAllGuests(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveGuest")
	public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest){
		HttpHeaders responseHeaders = new HttpHeaders();
		if(roomService.getRoom(guest.getRoomId())!=null) {
			return new ResponseEntity<Guest>(guestService.saveGuest(guest),HttpStatus.OK);
		}else {
			responseHeaders.set("errormsg", "No such room available");
			return new ResponseEntity<>(responseHeaders,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/saveAllGuests")
	public ResponseEntity<List<Guest>> saveAllGuest(@RequestBody List<Guest> guests){
		return new ResponseEntity<List<Guest>>(guestService.saveAllGuests(guests),HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateGuest")
	public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
		HttpHeaders responseHeaders = new HttpHeaders();
		if(roomService.getRoom(guest.getRoomId())!=null && guestService.getGuest(guest.getGid())!=null) {
			return new ResponseEntity<Guest>(guestService.updateGuest(guest),HttpStatus.OK);
		}
		responseHeaders.set("errormsg", "No such room with this roomId Or Guest with this gid available");
		return new ResponseEntity<>(responseHeaders,HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping(value = "/deleteGuest/{id}")
	public ResponseEntity<Guest> deleteGuest(@PathVariable(name = "id") int id){
		guestService.deleteGuest(id);
		return new ResponseEntity<Guest>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAllGuests")
	public ResponseEntity<Guest> deleteAllGuests(@RequestBody List<Guest> guests){
		guestService.deleteAllGuests(guests);
		return new ResponseEntity<Guest>(HttpStatus.OK);
	}

}
