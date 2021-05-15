package com.example.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import com.example.model.Passengers;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shivam.rai
 *
 */
@Getter
@Setter
public class TicketDTO {

	//private Long ticketId;

	@NotEmpty(message = "Please enter trainNumber")
	private String trainNumber;
	
	@NotEmpty(message = "Please enter Cost")
	private String cost;

	@Future(message = "Enter Valid Dates")
	private LocalDate travelDate;

	@NotEmpty(message = "Please enter userId")
	private String userId;
	
	@NotEmpty(message = "Please enter source")
	private String source;
	
	@NotEmpty(message = "Please enter destination")
	private String destination;
	
	private List<Passengers> passengers;
}
