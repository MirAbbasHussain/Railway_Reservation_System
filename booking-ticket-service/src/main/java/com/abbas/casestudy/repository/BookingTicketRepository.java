package com.abbas.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abbas.casestudy.model.BookingTicket;

public interface BookingTicketRepository extends MongoRepository<BookingTicket, String> {

	}