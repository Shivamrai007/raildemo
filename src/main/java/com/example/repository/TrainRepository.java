package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Train;

/**
 * @author shivam.rai
 *
 */
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

	public List<Train> findBySourceAndDestination(String source,String destination);
	
	public List<Train> findTrainBySourceAndDestinationAndStartDate(String source,String destination,LocalDate startDate);
	
	public List<Train> findBySourceAndDestinationAndStartTime(String source,String destination,String startTime);
	
	public List<Train> findBySourceAndDestinationAndStartDateOrStartTime(String source,String destination,String startDate,String startTime);
	
	public Train findByTrainNo(String trainNo);
}
