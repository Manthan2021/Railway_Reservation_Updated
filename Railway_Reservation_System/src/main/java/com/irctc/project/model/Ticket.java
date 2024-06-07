package com.irctc.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ticket")

public class Ticket {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long tid;
private long train_id;
private String fromst;
private String tost;
private String deptdate;
private String arrdate;
private String deptTime;
private String arrTime;

@JsonIgnore
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="ticket_id")
private List<Passenger> passenger=new ArrayList<Passenger>();


public Ticket() {
	super();
	// TODO Auto-generated constructor stub
}


public Ticket(long train_id, String fromst, String tost, String deptdate, String arrdate, String deptTime,
		String arrTime) {
	super();
	this.train_id = train_id;
	this.fromst = fromst;
	this.tost = tost;
	this.deptdate = deptdate;
	this.arrdate = arrdate;
	this.deptTime = deptTime;
	this.arrTime = arrTime;
}


public long getTid() {
	return tid;
}


public void setTid(long tid) {
	this.tid = tid;
}


public long getTrain_id() {
	return train_id;
}


public void setTrain_id(long train_id) {
	this.train_id = train_id;
}


public String getFromst() {
	return fromst;
}


public void setFromst(String fromst) {
	this.fromst = fromst;
}


public String getTost() {
	return tost;
}


public void setTost(String tost) {
	this.tost = tost;
}


public String getDeptdate() {
	return deptdate;
}


public void setDeptdate(String deptdate) {
	this.deptdate = deptdate;
}


public String getArrdate() {
	return arrdate;
}


public void setArrdate(String arrdate) {
	this.arrdate = arrdate;
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


public List<Passenger> getPassenger() {
	return passenger;
}


public void setPassenger(List<Passenger> passenger) {
	this.passenger = passenger;
}

}
