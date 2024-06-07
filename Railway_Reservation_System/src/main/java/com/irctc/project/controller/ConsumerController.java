package com.irctc.project.controller;




import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.irctc.project.exception.ErrorDetails;
import com.irctc.project.exception.ResourceNotFoundException;
import com.irctc.project.exception.ResourceNotFoundException2;
import com.irctc.project.model.Consumer;
import com.irctc.project.repository.ConsumerRepository;
import com.irctc.project.service.ConsumerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ConsumerController {

	@Autowired
	private ConsumerRepository cRepo;
	
	@Autowired
	private ConsumerService cService;
	
	Logger logger= LoggerFactory.getLogger(ConsumerController.class);
	
	@PostMapping("/consumer")
	public Consumer saveConsumer(@Validated @RequestBody Consumer consumer) {
		
		Consumer c=new Consumer();
		c.setEmail(consumer.getEmail());
		c.setFname(consumer.getFname());
		c.setLname(consumer.getLname());
		c.setMobilenumber(consumer.getMobilenumber());
		c.setPassword(consumer.getPassword());
		
		cService.saveConsumer(c);
		logger.info("Data saved successfully");
		return consumer;
	}
	
	@GetMapping("/getConsumer/{email}")
    public Consumer getConsumer(@PathVariable String email) throws ResourceNotFoundException2 {
		
		
		Consumer c=cRepo.findItByEmail(email).orElseThrow(()->
				new ResourceNotFoundException2("Consumer","email",email));
		
		return c;
	}
	
	@PostMapping("/consumerlogin") 
	public Boolean loginConsumer(@Validated @RequestBody Consumer consumer) throws ResourceNotFoundException 
	{
		Boolean a=false;
		String email=consumer.getEmail();
		String password=consumer.getPassword();
		
		Consumer c= cRepo.findItByEmail(email).orElseThrow(()->
		new ResourceNotFoundException("user not exist " + email));
		
		if(email.equals(c.getEmail()) && password.equals(c.getPassword()))
		{
			a=true;
		}
		return a;
	}

	@ExceptionHandler(ResourceNotFoundException2.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException2 exception,
    		WebRequest webRequest){
    	ErrorDetails errorDetails=new ErrorDetails(
    			LocalDateTime.now(),
    			exception.getMessage(),
    			webRequest.getDescription(false),
    			"USER_NOT_FOUND"
    			);
    	 return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException2(ResourceNotFoundException exception,
//    		WebRequest webRequest){
//    	ErrorDetails errorDetails=new ErrorDetails(
//    			LocalDateTime.now(),
//    			exception.getMessage(),
//    			webRequest.getDescription(false),
//    			"USER_NOT_Exist"
//    			);
//    	 return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
	
	
}
