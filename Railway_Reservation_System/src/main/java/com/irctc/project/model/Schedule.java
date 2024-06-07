package com.irctc.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private long trainId;
private String deptTime;
private String arrTime;
private long stationId;



public Schedule() {
	super();
	// TODO Auto-generated constructor stub
}



public Schedule(long trainId, String deptTime, String arrTime, long stationId) {
	super();
	this.trainId = trainId;
	this.deptTime = deptTime;
	this.arrTime = arrTime;
	this.stationId = stationId;
}



public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public long getTrainId() {
	return trainId;
}



public void setTrainId(long trainId) {
	this.trainId = trainId;
}



public String getDeptTime() {
	return deptTime;
}



public void setDeptTime(String deptTime) {
	this.deptTime = deptTime;
}



public String getArrTime() {
	return arrTime;
}



public void setArrTime(String arrTime) {
	this.arrTime = arrTime;
}



public long getStationId() {
	return stationId;
}



public void setStationId(long stationId) {
	this.stationId = stationId;
}



}
