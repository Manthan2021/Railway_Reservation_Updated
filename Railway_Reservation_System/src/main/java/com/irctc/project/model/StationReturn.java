package com.irctc.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="StationReturn")

public class StationReturn {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stationId;
	private String stop;
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="station_train_return_mapping",
			joinColumns = @JoinColumn(name = "station_id"), 
			  inverseJoinColumns = @JoinColumn(name = "train_id"))
	private List<TrainReturn> trains=new ArrayList<>();


	public StationReturn() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StationReturn(String stop, List<TrainReturn> trains) {
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


	public List<TrainReturn> getTrains() {
		return trains;
	}


	public void setTrains(List<TrainReturn> trains) {
		this.trains = trains;
	}
	
}
