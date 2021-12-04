package com.abbas.casestudy.service;

import java.util.List;
import java.util.Optional;

import com.abbas.casestudy.exception.EmptyInputException;
import com.abbas.casestudy.exception.TrainNotfoundException;
import com.abbas.casestudy.model.Train;

public interface TrainService {
	public abstract Train addTrain (Train train) throws EmptyInputException;
	public abstract List<Train> getTrains();
	public abstract Optional<Train> getTrainbyId(String id) throws TrainNotfoundException;
	public abstract Train updateTrain(String trainid, Train t) throws TrainNotfoundException;
	public abstract void deleteTrain(String id) throws TrainNotfoundException;

}
