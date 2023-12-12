package com.pkg.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@Column(name="ticket_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketNumber;
	
	@Column(name="phone_number",length = 10,nullable = false)
	private String phoneNumber;
	
	@Column(name="email_id",nullable = false)
	private String emailId;
	
	@Column(nullable = false)
	private String status;
	
	@Column(name="logged_date_time",nullable = false)
	private LocalDateTime loggedDateTime;
	
	@Column(nullable = false)
	private String issue;
	
	@Column(name="raised_by",nullable = false)
	private Integer raisedBy;
	
	@Column(nullable = false)
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

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", status=" + status + ", loggedDateTime=" + loggedDateTime + ", issue=" + issue + ", raisedBy="
				+ raisedBy + ", category=" + category + "]";
	}
	
	
}
