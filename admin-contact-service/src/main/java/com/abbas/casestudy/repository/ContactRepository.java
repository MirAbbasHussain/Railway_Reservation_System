package com.abbas.casestudy.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.abbas.casestudy.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{

}
