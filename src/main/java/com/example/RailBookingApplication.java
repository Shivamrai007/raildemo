package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan("com.example")
public class RailBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailBookingApplication.class, args);
	}

}
//http://localhost:8080/swagger-ui.html