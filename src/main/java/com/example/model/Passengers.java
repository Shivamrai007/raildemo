package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shivam.rai
 *
 */
@Entity
@Getter
@Setter
public class Passengers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passengersId; //seat Number
	private String passengersName;
	private String age;
	
	
}