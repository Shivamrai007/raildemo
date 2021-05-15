package com.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


/**
 * @author shivam.rai
 *
 */
@Entity
@Getter
@Setter
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	private String trainNumber;
	private String cost;
	
	@Column(columnDefinition = "DATE")
	private LocalDate travelDate;
	
	private String userId;
	private String source;
	private String destination;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Passengers> passengers = new ArrayList<Passengers>(); 
	
}