package com.hostel.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gid;
	private String firstName;
	private String lastName;
	private long mobileNo;
	private int age;
	private String adharNumber;
	private boolean payment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Room room;
	@Transient
	private int roomId;
}
