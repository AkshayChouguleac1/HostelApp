package com.hostel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.Entities.Room;
import com.hostel.Service.RoomService;
@RestController
@RequestMapping(value = "/Rooms")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@GetMapping(value = "/getRoom/{id}")
	public ResponseEntity<Room> getRoom(@PathVariable(name = "id") int id){
		return new ResponseEntity<Room>(roomService.getRoom(id),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllRooms")
	public ResponseEntity<List<Room>> getAllRooms(){
		return new ResponseEntity<List<Room>>(roomService.getAllRooms(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveRoom")
	public ResponseEntity<Room> saveRoom(@RequestBody Room room){
		return new ResponseEntity<Room>(roomService.saveRoom(room),HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveAllRooms")
	public ResponseEntity<List<Room>> saveAllRoom(@RequestBody List<Room> rooms){
		return new ResponseEntity<List<Room>>(roomService.saveAllRooms(rooms),HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateRoom")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room){
		return new ResponseEntity<Room>(roomService.updateRoom(room),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteRoom/{id}")
	public ResponseEntity<Room> deleteRoom(@PathVariable(name = "id") int id){
		roomService.deleteRoom(id);
		return new ResponseEntity<Room>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAllRooms")
	public ResponseEntity<Room> deleteAllRooms(@RequestBody List<Room> rooms){
		roomService.deleteAllRooms(rooms);
		return new ResponseEntity<Room>(HttpStatus.OK);
	}

}
