package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TrainDTO;
import com.example.model.Train;
import com.example.service.TrainService;

/**
 * @author shivam.rai
 *
 */
@RestController
@RequestMapping(name = "/train")
public class TrainController {
	
	@Autowired
	TrainService trainService;
	
	private Logger logger = LoggerFactory.getLogger(TrainController.class);

	/**
	 * @param train
	 */
	@PostMapping("")
	public void saveTrain(@RequestBody @Valid TrainDTO trainDTO) {
		Train train = new Train();
		BeanUtils.copyProperties(trainDTO, train);
		trainService.saveTrain(train);
		logger.info("Train Saved Succesfully.");
	}
	
	/**
	 * @param source
	 * @param destination
	 * @param date
	 * @param time
	 * @return
	 */
	@GetMapping("")
	public List<Train> findTrainBySourceAndDestination(@RequestParam(required = true) String source,@RequestParam(required = true) String destination,@RequestParam(required = false) String date,@RequestParam(required = false) String time){
		logger.info("Train Searching initiated...");
		if (date != null) {
			return trainService.findTrainBySourceAndDestinationAndStartDate(source,destination,date);
		}else if(time != null) {
			return trainService.findBySourceAndDestinationAndStartTime(source, destination, time);
		}else {
			return trainService.findTrainBySourceAndDestination(source,destination);
		}
		
	}

}
