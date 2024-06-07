package com.irctc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irctc.project.model.Ticket;
import com.irctc.project.model.TicketRequest;
import com.irctc.project.model.ticketpassenger;
import com.irctc.project.repository.PassengerRepository;
import com.irctc.project.repository.TicketRepository;
import com.irctc.project.service.TicketService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TicketController {
	
	@Autowired
	private TicketRepository tRepo;
	
	@Autowired
	private PassengerRepository pRepo;
	
	@Autowired
	private TicketService tService;
	
	@PostMapping("/addTicket")
	public Ticket addTicket(@RequestBody TicketRequest ticket) {
		Ticket t=tService.addTicketWithPassengers(ticket);
        return t;	
	}

	
	
	@GetMapping("/getTicket/{id}")
	public List<ticketpassenger> getAllTicket(@PathVariable long id){
		return tService.getTheTicket(id);
	}
	
	
	
	
	
}
	

