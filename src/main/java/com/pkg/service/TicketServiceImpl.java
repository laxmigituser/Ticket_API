package com.pkg.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.dto.TicketDTO;
import com.pkg.entity.Ticket;
import com.pkg.exception.TicketException;
import com.pkg.repository.TicketRepository;
import com.pkg.utilities.TicketConstants;

import jakarta.transaction.Transactional;
@Service
@Transactional
//@PropertySource("classath:ValidationMessages.properties")
public class TicketServiceImpl implements TicketService{
@Autowired
private TicketRepository repo;

	@Override
	public TicketDTO raiseTicket(TicketDTO dto) throws TicketException {
		Ticket ticket = TicketDTO.prepareEntity(dto);
		ticket.setStatus("OPEN");
		ticket.setLoggedDateTime(LocalDateTime.now());
		ticket=repo.saveAndFlush(ticket);
		return TicketDTO.prepareDTO(ticket);
	}
	
	@Override
	public TicketDTO closeTicket(Integer ticketNumber) throws TicketException {
		Optional<Ticket> ticket = repo.findById(ticketNumber);
		if(ticket.isEmpty()) {
			throw new TicketException(TicketConstants.TICKET_NOT_FOUND.toString());
		}
		if(ticket.get().getStatus().equalsIgnoreCase("CLOSED")) {			
			throw new TicketException(TicketConstants.TICKET_ALREADY_CLOSED.toString());
		}
		ticket.get().setStatus("CLOSED");
		repo.save(ticket.get());
		return TicketDTO.prepareDTO(ticket.get());
		
	}

	@Override
	public TicketDTO searchTicket(Integer ticketNumber) throws TicketException {
		Optional<Ticket> ticket = repo.findById(ticketNumber);
		if(ticket.isEmpty()) {
			throw new TicketException(TicketConstants.TICKET_NOT_FOUND.toString());
		}
		return TicketDTO.prepareDTO(ticket.get());
	}

	@Override
	public List<TicketDTO> getReport(String email) throws TicketException {
		List<Ticket> ticketlist = repo.findByEmailId(email);
		if(ticketlist.isEmpty()) {
			throw new TicketException(TicketConstants.TICKET_NOT_RAISED.toString());
		}
		List<TicketDTO> dtoList=new ArrayList<>();
		for(Ticket t:ticketlist) {
			dtoList.add(TicketDTO.prepareDTO(t));
		}
		return dtoList;
	}

}
