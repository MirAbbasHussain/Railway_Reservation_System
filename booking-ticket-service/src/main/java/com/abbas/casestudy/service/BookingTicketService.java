package com.abbas.casestudy.service;

import java.util.List;
import java.util.Optional;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TicketNotfoundException;
import com.abbas.casestudy.model.BookingTicket;

public interface BookingTicketService {
	public abstract BookingTicket addBook(BookingTicket book) throws EmptyInputException;
	public abstract Optional<BookingTicket> getBook( String id) throws TicketNotfoundException;
	public abstract BookingTicket updateTicket(String id, BookingTicket ticket ) throws TicketNotfoundException;
	public abstract String deleteTicket(String id) throws TicketNotfoundException;
	public abstract List<BookingTicket> getBook();

}
