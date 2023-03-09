package com.hostel.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.Dao.RoomRepo;
import com.hostel.Entities.Room;
import com.hostel.Entities.Room;
import com.hostel.Service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomRepo roomRepo;
	
	@Override
	public Room getRoom(Integer id) {
		Room foundRoom = roomRepo.findById(id).orElse(null);
		return foundRoom;
	}

	@Override
	public List<Room> getAllRooms() {
		List<Room> allRooms = roomRepo.findAll();
		return allRooms;
	}

	@Override
	public Room saveRoom(Room room) {
		Room savedRoom = roomRepo.save(room);
		return savedRoom;
	}

	@Override 
	public List<Room> saveAllRooms(List<Room> rooms) {
		List<Room> savedRooms = roomRepo.saveAll(rooms);
		return savedRooms;
	}

	@Override
	public void deleteRoom(Integer id) {
		roomRepo.deleteById(id);
	}
	
	@Override
	public void deleteAllRooms(List<Room> rooms) {
		roomRepo.deleteAll(rooms);
	}


	@Override
	public Room updateRoom(Room room) {
		Room existingRoom = roomRepo.findById(room.getRid()).orElse(null);
		if(existingRoom != null) {
			existingRoom.setBedCount(room.getBedCount());
			existingRoom.setRoomType(room.getRoomType());
			return existingRoom;
		}
		return null;
	}

	

}
