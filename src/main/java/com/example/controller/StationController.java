package com.example.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.StationDTO;
import com.example.model.Station;
import com.example.service.StationService;
import com.example.service.impl.TicketServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author shivam.rai
 *
 */
@RestController
@RequestMapping("/station")
public class StationController {
	
	@Autowired StationService stationService;
	
	private Logger logger = LoggerFactory.getLogger(StationController.class);


	/**
	 * @param station
	 */
	@PostMapping("")
	public void saveStation(@RequestBody @Valid StationDTO stationDTO) {
		logger.info("Saving Station in database...");
		Station station = new Station();
		BeanUtils.copyProperties(stationDTO, station);
		stationService.saveStation(station);
	}
}
