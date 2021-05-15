package com.example.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationDTO {
	
	@NotEmpty(message = "Please enter name")
	private String name;
	
	@NotEmpty(message = "Please enter code")
	private String code;
	
	@NotEmpty(message = "Please enter location")
	private String location;
}
