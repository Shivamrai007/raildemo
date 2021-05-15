package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Tickets;

/**
 * @author shivam.rai
 *
 */
@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
	
	public List<Tickets> findByUserId(String userId);

}
