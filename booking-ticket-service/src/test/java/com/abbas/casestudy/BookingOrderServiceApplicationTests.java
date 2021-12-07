package com.abbas.casestudy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.model.BookingTicket;
import com.abbas.casestudy.repository.BookingTicketRepository;
import com.abbas.casestudy.service.BookingTicketService;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookingOrderServiceApplicationTests {

	@Autowired
	BookingTicketService service;

	@MockBean
	BookingTicketRepository repository;

	@Test
	public void getTicketTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new BookingTicket("123",3,"Chennai","Bangalore"),new BookingTicket("124",2,"Chennai","Mumbai")).collect(Collectors.toList()));
		assertEquals(2,service.getBook().size());

	}
	@Test
	public void addTrainTest() throws EmptyInputException {
		BookingTicket ticket = new BookingTicket("123",3,"Chennai","Bangalore");
		when(repository.save(ticket)).thenReturn(ticket);
		assertEquals(ticket, service.addBook(ticket));
	}
}
