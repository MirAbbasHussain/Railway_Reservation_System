package com.abbas.casestudy.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.model.Contact;
import com.abbas.casestudy.service.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	@Autowired
	private ContactService contactservice;

	@PostMapping("/addContact")
	public String saveBook(@RequestBody Contact contact) throws EmptyInputException  {
		if(contact.getName().isEmpty() || contact.getName().length() ==0) {
			throw new EmptyInputException();
		}
		contactservice.addContact(contact);
		return "Added contact with id :  " + contact.getId();
	}

	@GetMapping("/findAllContacts")
	public List<Contact> getContacts(){
		return contactservice.getContact();
	}
	
	@GetMapping("/findAllContacts/{id}")
	public Optional<Contact> getContact(@PathVariable String id){
		return contactservice.getContactbyId(id);
	}

	@DeleteMapping("/delcontact/{id}")
	public String deleteContact (@PathVariable String id) {
		contactservice.deleteContact(id);
		return "Contact deleted with id : "+id;
		}
}
