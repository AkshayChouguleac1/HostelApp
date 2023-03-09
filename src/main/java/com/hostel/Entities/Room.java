package com.hostel.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	private String roomType;
	private int bedCount;
	@OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Guest> guests;

}
