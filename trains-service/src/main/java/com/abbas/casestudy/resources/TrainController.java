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
import com.abbas.casestudy.exception.TrainNotfoundException;
import com.abbas.casestudy.model.Train;
import com.abbas.casestudy.service.TrainServiceImpl;


@RestController
@RequestMapping("/trains")
public class TrainController {

	@Autowired
	private TrainServiceImpl trainservice;

	@PostMapping("/addTrain")
	public String saveTrain(@RequestBody Train trainid) throws EmptyInputException {
		trainservice.addTrain(trainid);
		return "Added train with id :  " + trainid.getTrainid();
	}
    @GetMapping("/findAllTrains")
    public List<Train> getTrains(){
	return trainservice.getTrains();
    }

	@GetMapping("{trainid}")
	public Optional<Train> getTrain(@PathVariable String trainid) throws TrainNotfoundException{
		return trainservice.getTrainbyId(trainid);
	}

	@DeleteMapping("/delete/{trainid}")
	public String deleteTrain (@PathVariable String trainid) throws TrainNotfoundException {
		trainservice.deleteTrain(trainid);
		return "Train deleted with id : "+trainid;
	}
	@PutMapping("/update/{trainid}")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train t ) throws TrainNotfoundException {
		t.setTrainid(trainid);
		trainservice.updateTrain(trainid, t);
		return t;

	}



}
