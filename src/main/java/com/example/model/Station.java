package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


/**
 * @author shivam.rai
 *
 */
@Entity
@Getter
@Setter
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stationId;
	
	private String name;
	private String code;
	private String location;
}

