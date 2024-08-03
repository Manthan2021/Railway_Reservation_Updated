package com.irctc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irctc.project.model.BankLoginCreds;
import com.irctc.project.model.Ticket;
import com.irctc.project.model.TicketRequest;
import com.irctc.project.model.ticketpassenger;
import com.irctc.project.repository.PassengerRepository;
import com.irctc.project.repository.TicketRepository;
import com.irctc.project.service.TicketService;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TicketController {
	
	@Autowired
	private TicketRepository tRepo;
	
	@Autowired
	private PassengerRepository pRepo;
	
	@Autowired
	private TicketService tService;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	@PostMapping("/addTicket")
	public Ticket addTicket(@RequestBody TicketRequest ticket) {
		Ticket t=tService.addTicketWithPassengers(ticket);
        return t;	
	}
	
	//http://localhost:6767/irctc/validateBankCreds
	@PostMapping("/validateBankCreds")
	public Boolean validateBank(@RequestBody BankLoginCreds loginCreds) {
		//restTemplate.getForEntity("http://localhost:9999/obs/consumerlogin")
//		ResponseEntity<Boolean> responseEntity=restTemplate.postForEntity("http://localhost:9999/obs/data/userlogin", loginCreds,Boolean.class);
//		
//		Boolean b=responseEntity.getBody();
		Boolean b=webClient.post().uri("http://localhost:9999/obs/data/userlogin").body(Mono.just(loginCreds), BankLoginCreds.class).retrieve().bodyToMono(Boolean.class).block();
		
		
		return b;
			
	}

	@GetMapping("/getBankID/{mail}")
	public String getBankID(@PathVariable String mail){
		
		String BankId=webClient.get().uri("http://localhost:9999/obs/data/getId/" + mail).retrieve().bodyToMono(String.class).block();
		return BankId;
		
	}
	
	
	@GetMapping("/getTicket/{id}")
	public List<ticketpassenger> getAllTicket(@PathVariable long id){
		return tService.getTheTicket(id);
	}
	
	
	
	
	
}
	

