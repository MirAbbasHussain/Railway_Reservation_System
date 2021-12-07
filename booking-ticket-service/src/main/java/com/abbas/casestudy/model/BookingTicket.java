package com.abbas.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tickets")
public class BookingTicket {
	
	@Id
	private String id;
	private  int quantity;
	private String startStation;
	private String endStation;
	
	public BookingTicket() {
		
	}

	public BookingTicket(String id, int quantity, String startStation, String endStation) {
		this.id = id;
		this.quantity = quantity;
		this.startStation = startStation;
		this.endStation = endStation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "BookingOrder [id=" + id + ", quantity=" + quantity + ", startStation=" + startStation + ", endStation="
				+ endStation + "]";
	}


	

	

	

}
