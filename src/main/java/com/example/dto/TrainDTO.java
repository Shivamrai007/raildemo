package com.example.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shivam.rai
 *
 */
@Getter
@Setter
public class TrainDTO {

	
	@NotEmpty(message = "Please enter trainName")
	private String trainName;
	
	@NotEmpty(message = "Please enter train Number")
	private String trainNo;

	@NotEmpty(message = "Please enter available Seats")
	private String availableSeats;

	@FutureOrPresent(message = "Please Enter Valid Date")
	private LocalDate startDate;

	@NotEmpty(message = "Please enter start time")
	private String startTime;

	@NotEmpty(message = "Please enter source")
	private String source;
	
	@NotEmpty(message = "Please enter destination")
	private String destination;
}
