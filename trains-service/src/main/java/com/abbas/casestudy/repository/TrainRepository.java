package com.abbas.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abbas.casestudy.model.Train;

public interface TrainRepository extends MongoRepository<Train, String>{

}
