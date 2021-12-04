package com.abbas.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TicketNotfoundException;
import com.abbas.casestudy.model.BookingTicket;
import com.abbas.casestudy.repository.BookingTicketRepository;

@Service
public class BookingServiceImpl implements BookingTicketService{

	@Autowired
	private BookingTicketRepository bookrepository;

	@Override
	public BookingTicket addBook(BookingTicket book) throws EmptyInputException {
		if(book.getQuantity().isEmpty() || book.getStartStation().isEmpty() || book.getEndStation().isEmpty()) {
			throw new EmptyInputException();
		}
		return bookrepository.save(book);

	}

	@Override
	public List<BookingTicket> getBook(){

		return bookrepository.findAll();

	}

	@Override
	public Optional<BookingTicket> getBook( String id) throws TicketNotfoundException{
		boolean isTicketExist = bookrepository.existsById(id);
		if(isTicketExist) {
			return bookrepository.findById(id);
		}else {
			throw new TicketNotfoundException();
		}

	}
	@Override
	public BookingTicket updateTicket(String id, BookingTicket ticket ) throws TicketNotfoundException {
		boolean isTicketExist = bookrepository.existsById(id);
		if(isTicketExist) {
			ticket.setId(id);
			bookrepository.save(ticket);
			return ticket;
		}else {
			throw new TicketNotfoundException();
		}
	}

	@Override
	public String deleteTicket(String id) throws TicketNotfoundException {
		boolean isTicketExist = bookrepository.existsById(id);
		if(isTicketExist) {
			bookrepository.deleteById(id);
			return "Ticket deleted with id : "+id;
		}else {
			throw new TicketNotfoundException();
		}

	}


}
