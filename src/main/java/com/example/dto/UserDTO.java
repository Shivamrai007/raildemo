package com.example.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import com.example.model.Address;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shivam.rai
 *
 */
@Getter
@Setter
public class UserDTO {

	//private Long userId;
	
	@NotEmpty(message = "Please enter username")
	private String username;
	
	@NotEmpty(message = "Please enter password")
	private String password;
	
    @NotEmpty(message = "Please enter email")
	private String email;
    
    @DecimalMax(value="100")
    @DecimalMin(value="1")
	private BigDecimal age;
    
    @NotEmpty(message = "Contact Number is mandatory")
    @Size(max=10,min=10,message = "Should contain 10 digits contact number.")
	private String contactNo;
	
    @NotEmpty(message = "Role is mandatory")
	private String userRole;
	
	private List<Address> address = new ArrayList<>();
	
	
}
