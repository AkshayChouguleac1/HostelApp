package com.hostel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.Entities.Room;
@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{

}
