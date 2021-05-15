package com.example.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.UserController;
import com.example.exception.TrainNotFoundException;
import com.example.model.Train;
import com.example.repository.TrainRepository;
import com.example.service.TrainService;

/**
 * @author shivam.rai
 *
 */
@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainRepository trainRepository;
	
	private Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);

	public void saveTrain(Train train) {
		trainRepository.save(train);
	}

	public List<Train> findTrainBySourceAndDestination(String source, String destination) {
		logger.info("Searching train initiated...");
		return trainRepository.findBySourceAndDestination(source, destination);
	}

	public List<Train> findTrainBySourceAndDestinationAndStartDate(String source, String destination, String date) {
		logger.info("Searching train initiated...");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
		return trainRepository.findTrainBySourceAndDestinationAndStartDate(source, destination, localDate);

	}

	public List<Train> findBySourceAndDestinationAndStartTime(String source, String destination, String time) {
		logger.info("Searching train initiated...");
		return trainRepository.findBySourceAndDestinationAndStartTime(source, destination, time);
	}

	
	@Override
	public Train findByTrainNo(String trainNo) throws TrainNotFoundException {
		logger.info("Searching train initiated with trainNumber : ",trainNo);
		Train train = trainRepository.findByTrainNo(trainNo);
		
		if (train != null) {
			return train;
		}else {
			throw new TrainNotFoundException("Train not found with Train Number "+trainNo);
		}
	}
	
	public Train updateTrainByTrainNumber(String trainNo, Train train) throws TrainNotFoundException {
		logger.info("Updating Train..");
		Train train2 = findByTrainNo(trainNo);
		train2.setAvailableSeats(train.getAvailableSeats());
		train2.setDestination(train.getDestination());
		train2.setSource(train.getSource());
		train2.setStartDate(train.getStartDate());
		train2.setStartTime(train.getStartTime());
		train2.setTrainName(train.getTrainName());
		
		return trainRepository.save(train2);
	}

}
