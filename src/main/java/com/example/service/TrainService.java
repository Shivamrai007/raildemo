package com.example.service;

import java.util.List;

import com.example.exception.TrainNotFoundException;
import com.example.model.Train;


/**
 * @author shivam.rai
 *
 */
public interface TrainService {

	public void saveTrain(Train train);

	public List<Train> findTrainBySourceAndDestination(String source, String destination);

	public List<Train> findTrainBySourceAndDestinationAndStartDate(String source, String destination, String date);

	public List<Train> findBySourceAndDestinationAndStartTime(String source, String destination, String time);
	
	public Train findByTrainNo(String trainNo) throws TrainNotFoundException;
	
	public Train updateTrainByTrainNumber(String trainNo, Train train) throws TrainNotFoundException;
}
