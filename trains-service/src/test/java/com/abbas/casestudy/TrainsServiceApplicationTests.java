package com.abbas.casestudy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.abbas.casestudy.model.Train;
import com.abbas.casestudy.repository.TrainRepository;
import com.abbas.casestudy.service.TrainService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TrainsServiceApplicationTests {
	@Autowired
	private TrainService service;
	
	@MockBean
	private TrainRepository repository;
	
	@Test
	public void getTrainsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Train("123","Chennai Express","Chennai","Bangalore","12-10-2021 3:00pm", 500),new Train("123","Chennai Express","Chennai","Bangalore","12-10-2021 3:00pm", 500)).collect(Collectors.toList()));
				assertEquals(2,service.getTrains().size());
				
	}
	/*
	 * @Test public void getTrainbyIdTest() { String id="123";
	 * when(repository.findById(id)).thenReturn(Stream .of(new
	 * Train("123","Chennai Express","Chennai","Bangalore","12-10-2021 3:00pm",
	 * 500),new
	 * Train("123","Chennai Express","Chennai","Bangalore","12-10-2021 3:00pm",
	 * 500)).collect(Collectors.toList()));
	 * assertEquals(2,service.getTrains().size());
	 * 
	 * }
	 */
	
	@Test
	public void addTrainTest() throws EmptyInputException {
		Train train = new Train("123","Chennai Express","Chennai","Bangalore","12-10-2021 3:00pm", 500);
		when(repository.save(train)).thenReturn(train);
		assertEquals(train, service.addTrain(train));
	}
	
	/*
	 * @Test public void deleteTrainTest() throws TrainNotfoundException { String
	 * id="123"; Train train = new
	 * Train("123","Chennai Express","Chennai","Bangalore","12-10-2021 3:00pm",
	 * 500); service.deleteTrain(id); verify(repository, times(1)).deleteById(id); }
	 */
	
	
}
