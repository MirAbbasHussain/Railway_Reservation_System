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
import com.abbas.casestudy.model.Contact;
import com.abbas.casestudy.repository.ContactRepository;
import com.abbas.casestudy.service.ContactService;



@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceApplicationTests {

	@Autowired
	private ContactService service;
	
	@MockBean
	private ContactRepository repository;
	
	@Test
	public void getTrainTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Contact("123","abbas","1234567"), new Contact("124","mir","7654321")).collect(Collectors.toList()));
		assertEquals(2, service.getContact().size());
	}
	
	@Test
	public void addTrainTest() throws EmptyInputException {
		 Contact train =new  Contact("321","ravi","9876543");
		 when(repository.save(train)).thenReturn(train);
		 assertEquals(train,service.addContact(train));
	}
	

}
