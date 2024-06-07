package com.irctc.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="station")

public class Station {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stationId;
	private String stop;
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="station_train_mapping",
			joinColumns = @JoinColumn(name = "station_id"), 
			  inverseJoinColumns = @JoinColumn(name = "train_id"))
	private List<Train> trains=new ArrayList<>();
	
	
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Station(String stop, List<Train> trains) {
		super();
		this.stop = stop;
		this.trains = trains;
	}


	public Long getStationId() {
		return stationId;
	}


	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}


	public String getStop() {
		return stop;
	}


	public void setStop(String stop) {
		this.stop = stop;
	}


	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}	

}
