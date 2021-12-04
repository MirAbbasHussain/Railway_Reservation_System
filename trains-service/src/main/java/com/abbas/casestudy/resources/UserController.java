package com.abbas.casestudy.resources;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abbas.casestudy.exception.TrainNotfoundException;
import com.abbas.casestudy.model.Train;
import com.abbas.casestudy.service.TrainServiceImpl;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/trains/search")
public class UserController {
	
	@Autowired
	private TrainServiceImpl trainservice;

    @GetMapping("/findAllTrains")
    public List<Train> getTrains(){
	return trainservice.getTrains();
	
}
    @GetMapping("/findAllTrains/{trainid}")
    public Optional<Train> getTrains(@PathVariable String trainid) throws TrainNotfoundException{
	return trainservice.getTrainbyId(trainid);
}
	
}
