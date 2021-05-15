package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Station;
import com.example.model.Train;

/**
 * @author shivam.rai
 *
 */
@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

}
