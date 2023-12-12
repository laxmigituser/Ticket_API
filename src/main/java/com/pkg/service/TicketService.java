package com.pkg.service;

import java.util.List;

import com.pkg.dto.TicketDTO;
import com.pkg.exception.TicketException;

public interface TicketService {
TicketDTO raiseTicket(TicketDTO dto)throws TicketException;
TicketDTO closeTicket(Integer ticketNumber)throws TicketException;
TicketDTO searchTicket(Integer ticketNumber)throws TicketException;
List<TicketDTO>getReport(String email)throws TicketException;

}
