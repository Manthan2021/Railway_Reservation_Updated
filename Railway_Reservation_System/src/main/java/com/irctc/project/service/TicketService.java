package com.irctc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.project.model.Passenger;
import com.irctc.project.model.Ticket;
import com.irctc.project.model.TicketRequest;
import com.irctc.project.model.ticketpassenger;
import com.irctc.project.repository.PassengerRepository;
import com.irctc.project.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository tRepo;
	
	@Autowired
	PassengerRepository pRepo;

	public TicketService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ticket addTicketWithPassengers(TicketRequest t) {
		Ticket ticket=new Ticket();
        ticket.setArrdate(t.arrdate);	
        ticket.setArrTime(t.arrTime);
		ticket.setDeptdate(t.deptdate);
		ticket.setDeptTime(t.deptTime);
		ticket.setFromst(t.fromst);
		ticket.setTost(t.tost);
		ticket.setTid(t.tid);
	    ticket.setTrain_id(t.train_id);
	    ticket.setPassenger(t.passenger);
	    tRepo.save(ticket);
	    
	   return ticket;
        	
	}
	
//	public Ticket getTicket(long tid) {
//		Ticket t=new Ticket();
//		t=tRepo.getById(tid);
//		return t;
//		
//	}
	
	public List<ticketpassenger> getTheTicket(long id) {
		List<ticketpassenger> t=tRepo.fetchallTicket(id);
		return t;
		
	}
	
	
	
	
	
}
