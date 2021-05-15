package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TicketDTO;
import com.example.exception.TrainNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.exception.handling.Message;
import com.example.model.Tickets;
import com.example.service.TicketService;

/**
 * @author shivam.rai
 *
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	private Logger logger = LoggerFactory.getLogger(TicketController.class);

	/**
	 * @param ticketDTO
	 * @return
	 * @throws MethodArgumentNotValidException
	 * @throws UserNotFoundException
	 * @throws TrainNotFoundException
	 */
	@PostMapping("")
	public ResponseEntity<?> saveTicket(@RequestBody @Valid TicketDTO ticketDTO)
			throws MethodArgumentNotValidException, UserNotFoundException, TrainNotFoundException {
		logger.info("Train Saved Process Initiated...");
		TicketDTO ticketDTO2 = ticketService.saveTicket(ticketDTO);
		return new ResponseEntity<TicketDTO>(ticketDTO2, HttpStatus.CREATED);
	}

	/**
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{userId}")
	public List<TicketDTO> getTicketByUserId(@PathVariable Long userId) throws Exception {
		return ticketService.getTicketByUserId(String.valueOf(userId));
	}

	/**
	 * @param ticketId
	 */
	@DeleteMapping("/{ticketId}")
	public void deleteTicketById(@PathVariable Long ticketId) {
		logger.info("Deleting ticket Initiated...");
		ticketService.deleteTicketById(ticketId);
	}

}
