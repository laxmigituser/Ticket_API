package com.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.dto.TicketDTO;
import com.pkg.exception.TicketException;
import com.pkg.service.TicketServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/ticket")
//@Validated
public class TicketController {
	
	@Autowired
	private TicketServiceImpl ticketService;

	@PostMapping(value = "/raiseticket")
	ResponseEntity<TicketDTO> raiseTicket(@RequestBody TicketDTO dto) throws TicketException {
		TicketDTO ticketDTO = this.ticketService.raiseTicket(dto);
		return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
	}
	@PutMapping("/closeticket/{ticketNumber}")
	 ResponseEntity<TicketDTO> closeTicket(@PathVariable Integer ticketNumber) throws TicketException{
		TicketDTO closeTicket = this.ticketService.closeTicket(ticketNumber);
		return new ResponseEntity<TicketDTO>(closeTicket,HttpStatus.ACCEPTED);
	}
	@GetMapping("/searchticket/{ticketNumber}")
	ResponseEntity<TicketDTO> searchTicket(@PathVariable Integer ticketNumber)throws TicketException {
		TicketDTO searchTicket = this.ticketService.searchTicket(ticketNumber);
		return new ResponseEntity<>(searchTicket, HttpStatus.OK);
	}
	@GetMapping("/getticketreport/{emailId}")
	ResponseEntity<List<TicketDTO>> getRepost(@PathVariable String emailId)throws TicketException {		
		List<TicketDTO> list = this.ticketService.getReport(emailId);		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
