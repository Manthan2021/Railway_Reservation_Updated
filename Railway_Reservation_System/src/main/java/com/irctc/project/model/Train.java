package com.irctc.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="train")

public class Train {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long trainId;
	private String trainName;
	private long capacity;
	private String type;
	
	@JsonIgnore
	@ManyToMany(mappedBy="trains")
	private List<Station> stations=new ArrayList<>();
	
//	public Train(String trainName, long capacity, String type) {
//		super();
//		this.trainName = trainName;
//		this.capacity = capacity;
//		this.type = type;
//	}


		
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Train(long trainId, String trainName, long capacity, String type) {
		super();
		this.trainId = trainId;
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

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public void addStation(Station s) {
		this.stations.add(s);
	}


}
