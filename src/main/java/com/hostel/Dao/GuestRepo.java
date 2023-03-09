package com.hostel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.Entities.Guest;
@Repository
public interface GuestRepo extends JpaRepository<Guest, Integer>{

}
