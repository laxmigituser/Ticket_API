package com.pkg.dto;

import java.time.LocalDateTime;

import com.pkg.entity.Ticket;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TicketDTO {
	
	private Integer ticketNumber;
	
//	@NotNull(message = "NUMBER CANT BE BLANK")
//	@Pattern(regexp = "[1-9]{1}[0-9]{9}",message = "INVALID PHONE NUMBER")
	private String phoneNumber;
	
//	@NotNull(message = "EMAIL CANT BE BLANK")
//	@Email
	private String emailId;
	
	private String status;
	
	private LocalDateTime loggedDateTime;
	
//	@NotNull(message = "ISSUE CANT BE BLANK")
//	@Pattern(regexp = "[a-zA-Z]+([ ]?[a-zA-Z]+)*",message = "INVALID ISSUE TYPE")
	private String issue;
	
//	@Min(value = 100)
//	@Max(value = 999)
	private Integer raisedBy;
	
	@Pattern(regexp = "(product|service|enquiry)")
	private String category;

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLoggedDateTime() {
		return loggedDateTime;
	}

	public void setLoggedDateTime(LocalDateTime loggedDateTime) {
		this.loggedDateTime = loggedDateTime;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Integer getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Integer raisedBy) {
		this.raisedBy = raisedBy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
public static TicketDTO prepareDTO(Ticket ticket) {
	TicketDTO dto=new TicketDTO();
	dto.setCategory(ticket.getCategory());
	dto.setEmailId(ticket.getEmailId());
	dto.setIssue(ticket.getIssue());
	dto.setLoggedDateTime(ticket.getLoggedDateTime());
	dto.setPhoneNumber(ticket.getPhoneNumber());
	dto.setRaisedBy(ticket.getRaisedBy());
	dto.setStatus(ticket.getStatus());
	dto.setTicketNumber(ticket.getTicketNumber());
	return dto;
	
}
public static Ticket prepareEntity(TicketDTO dto) {
	Ticket ticket=new Ticket();
	ticket.setCategory(dto.getCategory());
	ticket.setEmailId(dto.getEmailId());
	ticket.setIssue(dto.getIssue());
	//ticket.setLoggedDateTime(ticket.getLoggedDateTime());
	ticket.setPhoneNumber(dto.getPhoneNumber());
	ticket.setRaisedBy(dto.getRaisedBy());
	//ticket.setStatus(ticket.getStatus());
	//ticket.setTicketNumber(ticket.getTicketNumber());
	return ticket;
	
}
}
