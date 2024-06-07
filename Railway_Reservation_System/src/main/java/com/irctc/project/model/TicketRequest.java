package com.irctc.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class TicketRequest {
	public long tid;
	public long train_id;
	public String fromst;
	public String tost;
	public String deptdate;
	public String arrdate;
	public String deptTime;
	public String arrTime;
	public List<Passenger> passenger=new ArrayList<Passenger>();

	
	
	
	
}
