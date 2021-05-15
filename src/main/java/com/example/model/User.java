package com.example.model;

import java.math.BigDecimal;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String username;
	
	private String password;
	
	private String email;
	private BigDecimal age;
	private String contactNo;
	@Column(name = "user_role", updatable = false, columnDefinition = "VARCHAR(1) NOT NULL COMMENT 'A = Admin , U = User'")
	private String userRole;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Address> address = new ArrayList<>();
	
	
}
