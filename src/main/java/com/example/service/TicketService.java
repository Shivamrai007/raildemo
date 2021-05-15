package com.example.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.TicketDTO;
import com.example.exception.TicketNotFoundException;
import com.example.exception.TrainNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.model.Tickets;

/**
 * @author shivam.rai
 *
 */
public interface TicketService {

	public TicketDTO saveTicket(TicketDTO ticketDTO) throws UserNotFoundException, TrainNotFoundException ;
	
	public TicketDTO getTicketById(Long ticketId) throws Exception ;
	
	public List<TicketDTO> getTicketByUserId(String userId) throws TicketNotFoundException;
	
	public Tickets updateTicket(Long ticketId, Tickets ticket)throws Exception ;
	
	
	 public void deleteTicketById(Long ticketId) ;
	
}
