package com.hostel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostel.Entities.Room;

public interface RoomService {
	public Room getRoom(Integer id);
	public List<Room> getAllRooms();
	public Room saveRoom(Room room);
	public List<Room> saveAllRooms(List<Room> rooms);
	public void deleteRoom(Integer id);
	public void deleteAllRooms(List<Room> rooms);
	public Room updateRoom(Room room);
}
