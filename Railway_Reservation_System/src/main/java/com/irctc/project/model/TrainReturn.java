package com.irctc.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="trainreturn")

public class TrainReturn {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long trainId;
	private String trainName;
	private long capacity;
	private String type;
	
	@ManyToMany(mappedBy="trains")
	private List<StationReturn> stations=new ArrayList<>();

	
	public TrainReturn() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TrainReturn(String trainName, long capacity, String type) {
		super();
		this.trainName = trainName;
		this.capacity = capacity;
		this.type = type;
	}


	
	public long getTrainId() {
		return trainId;
	}


	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}


	public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}


	public long getCapacity() {
		return capacity;
	}


	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}



	public void addStation(StationReturn stationreturn) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
