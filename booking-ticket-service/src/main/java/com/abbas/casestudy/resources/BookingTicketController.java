package com.abbas.casestudy.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TicketNotfoundException;
import com.abbas.casestudy.model.BookingTicket;
import com.abbas.casestudy.service.BookingServiceImpl;


@RestController
@RequestMapping("/tickets")
public class BookingTicketController {
	
	@Autowired
	private BookingServiceImpl bookService;

	@PostMapping("/addTicket")
	public String addBook(@RequestBody BookingTicket book) throws EmptyInputException {
		bookService.addBook(book);
		return "Booked ticket with id :  "+book.getId();

    }
	
	@GetMapping("/getAllTickets")
	public List<BookingTicket> getBook(){
		return  bookService.getBook();
	}
	
	@GetMapping("/{id}")
	public Optional<BookingTicket> getBook(@PathVariable String id) throws TicketNotfoundException{
		return  bookService.getBook(id);
	}
	@PutMapping("/update/{id}")
	public BookingTicket updateTicket(@PathVariable("id") String id,@RequestBody BookingTicket ticket ) throws TicketNotfoundException {
		ticket.setId(id);
		bookService.updateTicket(id, ticket);
		return ticket;
	}
		
	 @DeleteMapping("/del/{id}")
	 public String deleteTicket (@PathVariable String id) throws TicketNotfoundException {
		
			bookService.deleteTicket(id);
		
		return "Ticket deleted with id : "+id;
		}
	}