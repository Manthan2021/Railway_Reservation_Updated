package com.irctc.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="passenger")

public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid;
	private String pname;
	private int age;

	@ManyToOne
	@JoinColumn(name="ticket_id")
	private Ticket t;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Passenger(String pname, int age, Ticket t) {
		super();
		this.pname = pname;
		this.age = age;
		this.t = t;
	}


	public long getPid() {
		return pid;
	}


	public void setPid(long pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Ticket getT() {
		return t;
	}


	public void setT(Ticket t) {
		this.t = t;
	}


	
	
	
}
