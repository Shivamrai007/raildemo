package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainId;

	private String trainName;
	private String trainNo;

	private String availableSeats;

	@Column(columnDefinition = "DATE")
	private LocalDate startDate;

	// @Column(columnDefinition = "TIME")
	private String startTime;

	private String source;
	private String destination;
}