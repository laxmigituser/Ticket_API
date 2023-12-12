package com.pkg.utilities;

public enum TicketConstants {
//exception message constants
	TICKET_NOT_FOUND("ticket.not.found"),
	TICKET_NOT_RAISED("ticket.not.raised"),
	TICKET_ALREADY_CLOSED("ticket.already.closed"),
	GENERAL_EXCEPTION_MESSAGE("general.exception.message");
	
	
	//value attribute to hold enum constant vale
	private final String type;
	
	//assigns value of selected enum constant
	private TicketConstants(String type) {
		this.type=type;
	}
	@Override
	public String toString() {
		return type;
	}
}
