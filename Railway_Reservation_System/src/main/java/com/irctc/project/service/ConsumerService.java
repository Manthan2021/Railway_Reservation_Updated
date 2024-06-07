package com.irctc.project.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.project.exception.EmailAlreadyExistsException;
import com.irctc.project.model.Consumer;
import com.irctc.project.repository.ConsumerRepository;

@Service
@Transactional

public class ConsumerService {

	@Autowired
	public ConsumerRepository cRepo;
	
	public void saveConsumer(Consumer consumer) {
		Optional<Consumer> optionalUser =cRepo.findItByEmail(consumer.getEmail());
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists for a user");
		}
		
		cRepo.save(consumer);
	}
	
}
