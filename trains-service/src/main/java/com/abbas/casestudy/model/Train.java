package com.abbas.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Trains")
public class Train {

	@Id
	private String trainid;
	private String trainName;
	private String startStation;
	private String endStation;
	private String date;
	private int fare;
	private int capacity;

	public Train(String trainid, String trainName, String startStation, String endStation, String date, int fare, int capacity) {
		super();
		this.trainid = trainid;
		this.trainName = trainName;
		this.startStation = startStation;
		this.endStation = endStation;
		this.date = date;
		this.fare = fare;
		this.capacity= capacity;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	


	public Train() {

	}





	public String getTrainid() {
		return trainid;
	}


	public void setTrainid(String trainid2) {
		this.trainid = trainid2;
	}


	public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}


	public String getStartStation() {
		return startStation;
	}


	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}


	public String getEndStation() {
		return endStation;
	}


	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}


}
