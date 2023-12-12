package com.pkg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkg.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByEmailId(String emailId);

	Ticket findByTicketNumber(Integer ticketNumber);
}
