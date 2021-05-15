package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Station;
import com.example.repository.StationRepository;
import com.example.service.StationService;


/**
 * @author shivam.rai
 *
 */
@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationRepository stationRepository;

	public void saveStation(Station station) {
		stationRepository.save(station);
	}

}
