package com.abbas.casestudy.service;

import java.util.List;
import java.util.Optional;

import com.abbas.casestudy.exception.ContactNotfoundException;
import com.abbas.casestudy.model.Contact;
import com.abbas.casestudy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;
	

	public Contact addContact (Contact contact) {
		return contactrepository.save(contact);
	}

	public List<Contact> getContact() {
		
		List<Contact> contact = contactrepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<Contact> getContactbyId(String id) {
		boolean isTrainExist = contactrepository.existsById(id);
		if(isTrainExist) {
		return contactrepository.findById(id);
		}
		else {
			throw new ContactNotfoundException();
		}
	}

	public void deleteContact(String id) {
		boolean isTrainExist = contactrepository.existsById(id);
		if(isTrainExist) {
		contactrepository.deleteById(id);
		}
		else {
			throw new ContactNotfoundException();
		}
	}
}
