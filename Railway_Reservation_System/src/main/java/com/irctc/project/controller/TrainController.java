package com.irctc.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irctc.project.exception.ResourceNotFoundException;
import com.irctc.project.model.Schedule;
import com.irctc.project.model.Station;
import com.irctc.project.model.StationRequest;
import com.irctc.project.model.StationReturn;
import com.irctc.project.model.StationReturnRequest;
import com.irctc.project.model.StationTrain;
import com.irctc.project.model.Train;
import com.irctc.project.model.TrainReturn;
import com.irctc.project.repository.TrainRepository;
import com.irctc.project.repository.TrainReturnRepository;
import com.irctc.project.service.StationReturnService;
import com.irctc.project.service.StationService;
import com.irctc.project.service.TrainService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TrainController {
	
	
	
	@Autowired
	private TrainRepository tRepo;
	
	@Autowired 
	private StationService sService;
	
	@Autowired
	private TrainReturnRepository trRepo;
	
	@Autowired 
	private StationReturnService srService;
	
	@Autowired 
	private TrainService tService;
	
	
	
    @GetMapping("/trains")
	public List<Train> getAllTrain(){
	
    	return tService.listAll();

	}
	
	
	
	@PostMapping("/addStation")
	public Station addstation(@RequestBody StationRequest station) {
		
		return sService.addStationWithTrains(station);
		
	}
	
	@PostMapping("/addSchedule")
	public Schedule addschedule(@RequestBody Schedule s) {
		
		return sService.addSchedule(s);
	}
	
	@PostMapping("/addReturnStation")
	public StationReturn addreturnstation(@RequestBody StationReturnRequest stationreturn) {
	
		return srService.addStationWithTrains(stationreturn);
	}
	
	@PostMapping("/addtrain")
	public void addTrain(@RequestBody Train train) {
		 tService.saveTrain(train);
	}
	
	@PostMapping("/addreturntrain")
	public void addReturnTrain(@RequestBody TrainReturn train) {
		tService.saveReturnTrain(train);
	}
	
	
	
	@GetMapping("/getStation/{id}")
	public List<StationTrain> getallstation(@PathVariable Long id){

		return sService.getStationWithTrain(id);
		}
	
	@GetMapping("/getReturnStation/{id}")
	public List<StationTrain> getallreturnstation(@PathVariable Long id){

		return srService.getStationReturnWithTrain(id);
		}

	
	
//	@PutMapping("/products/{id}")
//	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long pId,
//	@Validated @RequestBody Product product)
//	throws ResourceNotFoundException
//	{
//	Product p=pRepo.findById(pId).orElseThrow(() ->
//	new ResourceNotFoundException("Product not found for this id :: " + pId));
//
//
//	p.setBrand(product.getBrand());
//	p.setMadein(product.getMadein());
//	p.setName(product.getName());
//	p.setPrice(product.getPrice());
//
//	final Product updatedProduct=pRepo.save(p);//invokes save method of JPA Repository
//	
//	return ResponseEntity.ok().body(updatedProduct);
//
//
//	}
	
	@PutMapping("/updatetraincapacity/{tid}")
	public ResponseEntity<Train> updateTrain(@PathVariable Long tid,
			@Validated @RequestBody Train train)throws ResourceNotFoundException
	{
		Train t=tRepo.findById(tid).orElseThrow(() -> 
		new ResourceNotFoundException("train not found for this id::" +tid));
		t.setTrainId(t.getTrainId());
		t.setTrainName(t.getTrainName());
		t.setCapacity(train.getCapacity());
		t.setType(t.getType());
		
		final Train updatedTrain=tRepo.save(t);
		return ResponseEntity.ok().body(updatedTrain);
				
	}
		
	
	@PutMapping("/updatetrainreturncapacity/{id}")
	public ResponseEntity<TrainReturn> updateReturnTrain(@PathVariable Long id,
			@Validated @RequestBody TrainReturn trainreturn)throws ResourceNotFoundException
	{
		TrainReturn tr=trRepo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("train not found for this id::"+id));
		tr.setTrainId(tr.getTrainId());
		tr.setTrainName(tr.getTrainName());
		tr.setCapacity(trainreturn.getCapacity());
		tr.setType(tr.getType());
		
		final TrainReturn updatedTrain=trRepo.save(tr);
		return ResponseEntity.ok().body(updatedTrain);
		
		
	}

	@GetMapping("/getTrain/{id}")
	public Train getTrain(@PathVariable Long id){
		Train t=tRepo.getById(id);
		return t;
		
	}
	
	
	@GetMapping("/getReturnTrain/{id}")
	public TrainReturn getReturnTrain(@PathVariable Long id){
		TrainReturn t=trRepo.getById(id);
		return t;
		
	}
	
	@GetMapping("/getResultant/{id1}/{id2}")
	public List<StationTrain> getResultantTrain(@PathVariable Long id1,@PathVariable Long id2 ){
		
		List<StationTrain> t1=getallstation(id1);
		List<StationTrain> t2=getallstation(id2);
		List<StationTrain> result=new ArrayList<>();
		
		for(StationTrain one:t1) {
			for(StationTrain two:t2) {
				
				if(one.getTrainId()==two.getTrainId()) {
				result.add(one);
				}					
			}
		}
		return result;
	}
	
	
	@GetMapping("/gettheStation/{id}")
	public Long getTheStation(@PathVariable String id) {
		
		List<Station> s=sService.getStation(id);
		return s.get(0).getStationId();
		
	}
	
	@GetMapping("/getallstations")
	public List<Station> getAllStations(){
		
		return sService.getallStations();
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

