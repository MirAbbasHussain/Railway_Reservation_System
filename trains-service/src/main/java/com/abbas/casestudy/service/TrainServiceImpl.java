package com.abbas.casestudy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TrainNotfoundException;
import com.abbas.casestudy.model.Train;
import com.abbas.casestudy.repository.TrainRepository;


@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainRepository trainrepository;

	@Override
	public Train addTrain (Train train) throws EmptyInputException {
		if(train.getTrainName().isEmpty() || train.getTrainName().length()==0) {
			throw new EmptyInputException();
		}
		return trainrepository.save(train);
	}

	@Override
	public List<Train> getTrains() {
		List<Train> train = trainrepository.findAll();
		System.out.println("Getting data from DB : " + train);
		return train;
	}

	@Override
	public Optional<Train> getTrainbyId(String id) throws TrainNotfoundException {
		boolean isTrainExist = trainrepository.existsById(id);
		if(isTrainExist) {
		return trainrepository.findById(id);
		}else {
			throw new TrainNotfoundException();
		}
	}

	@Override
	public Train updateTrain(String trainid, Train t) throws TrainNotfoundException {
		boolean isTrainExist = trainrepository.existsById(trainid);
		if(isTrainExist) {
		t.setTrainid(trainid);
		trainrepository.save(t);
		return t;
		}else {
			throw new TrainNotfoundException();
		}
	}

	@Override
	public void deleteTrain(String id) throws TrainNotfoundException {
		boolean isTrainExist = trainrepository.existsById(id);
		if(isTrainExist) {
		trainrepository.deleteById(id);
		}else {
			throw new TrainNotfoundException();
		}
	}
	


}
