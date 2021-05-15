package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.TicketDTO;
import com.example.exception.TicketNotFoundException;
import com.example.exception.TrainNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.model.Tickets;
import com.example.model.Train;
import com.example.repository.TicketsRepository;
import com.example.service.TicketService;
import com.example.service.TrainService;
import com.example.service.UserService;

/**
 * @author shivam.rai
 *
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketsRepository ticketsRepository;
	
	@Autowired
	TrainService trainService;

	@Autowired
	UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

	public TicketDTO saveTicket(TicketDTO ticketDTO) throws UserNotFoundException, TrainNotFoundException {

		if (userService.getUserById(Long.parseLong(ticketDTO.getUserId())) != null) {
			
			
			Train train = trainService.findByTrainNo(ticketDTO.getTrainNumber());
					
			if(Integer.parseInt(train.getAvailableSeats()) > ticketDTO.getPassengers().size()) {
				int availableSeats = Integer.parseInt(train.getAvailableSeats()) - ticketDTO.getPassengers().size();
				train.setAvailableSeats(availableSeats+"");
		
				Tickets ticket = new Tickets();
				BeanUtils.copyProperties(ticketDTO, ticket);
				
				Tickets savedTicket = ticketsRepository.save(ticket);
				
				if (savedTicket !=null) {
					trainService.updateTrainByTrainNumber(ticketDTO.getTrainNumber(), train);
				}
				
				BeanUtils.copyProperties(savedTicket, ticketDTO);
				return ticketDTO;
			}else {
				logger.info("Seats are not Available.");
				return null;
			}
			
			
		} else {
			throw new UserNotFoundException("Unable to locate user");
		}

	}

	@Override
	public TicketDTO getTicketById(Long ticketId) throws Exception {

		Optional<Tickets> tickets = ticketsRepository.findById(ticketId);

		if (tickets.isPresent()) {
			TicketDTO ticketDTO = new TicketDTO();
			BeanUtils.copyProperties(tickets.get(), ticketDTO);
			logger.info("Ticket Found");
			return ticketDTO;
		} else {
			logger.info("Ticket Not Found");
			throw new Exception("Ticket Not Found");
		}

	}

	@Override
	public List<TicketDTO> getTicketByUserId(String userId) throws TicketNotFoundException {

		List<Tickets> ticketList = ticketsRepository.findByUserId(userId);

		if (!ticketList.isEmpty()) {

			List<TicketDTO> ticketDTOList = new ArrayList<>();

			for (Tickets tickets2 : ticketList) {
				TicketDTO ticketDTO = new TicketDTO();
				BeanUtils.copyProperties(tickets2, ticketDTO);
				ticketDTOList.add(ticketDTO);
			}
			logger.info("Ticket  found with userId ",userId);
			return ticketDTOList;
		} else {
			logger.info("Ticket not found with userId ");
			throw new TicketNotFoundException("Ticket not found with userId " + userId);
		}

	}

	public Tickets updateTicket(Long ticketId, Tickets ticket) throws Exception {
		logger.info("Updating Ticket");
		TicketDTO tickets2 = getTicketById(ticketId);
		tickets2.setCost(ticket.getCost());
		tickets2.setDestination(ticket.getDestination());
		tickets2.setSource(ticket.getSource());
		tickets2.setUserId(ticket.getUserId());
		tickets2.setTravelDate(ticket.getTravelDate());
		tickets2.setTrainNumber(ticket.getTrainNumber());

		Tickets ticket3 = new Tickets();
		BeanUtils.copyProperties(tickets2, ticket3);

		return ticketsRepository.save(ticket3);
	}

	@Override
	public void deleteTicketById(Long ticketId) {
		logger.info("Deleting Ticket");
		ticketsRepository.deleteById(ticketId);

	}
}
