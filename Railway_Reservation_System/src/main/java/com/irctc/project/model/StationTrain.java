package com.irctc.project.model;

public class StationTrain {
	private Long stationId;
	private String stop;
	private long trainId;
	private String trainName;
	private long capacity;
	private String type;
	
	public StationTrain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StationTrain(Long stationId, String stop, long trainId, String trainName, long capacity, String type) {
		super();
		this.stationId = stationId;
		this.stop = stop;
		this.trainId = trainId;
		this.trainName = trainName;
		this.capacity = capacity;
		this.type = type;
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
	
	
}
