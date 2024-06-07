package com.irctc.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.project.model.Train;
import com.irctc.project.model.TrainReturn;
import com.irctc.project.repository.TrainRepository;
import com.irctc.project.repository.TrainReturnRepository;

@Service
@Transactional

public class TrainService {

	@Autowired
	public TrainRepository tRepo;
	
	@Autowired
	public TrainReturnRepository trRepo;
	
	public void saveTrain(Train t) {
		tRepo.save(t);		
	}
	
public List<Train> listAll(){
		
		return tRepo.findAll();
	}


	public void saveReturnTrain(TrainReturn tr) {
		
		trRepo.save(tr);
	}
	
	
	
	
	
}
