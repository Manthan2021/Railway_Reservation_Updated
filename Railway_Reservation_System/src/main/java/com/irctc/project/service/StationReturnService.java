package com.irctc.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.project.model.Station;
import com.irctc.project.model.StationRequest;
import com.irctc.project.model.StationReturn;
import com.irctc.project.model.StationReturnRequest;
import com.irctc.project.model.StationTrain;
import com.irctc.project.model.Train;
import com.irctc.project.model.TrainReturn;
import com.irctc.project.repository.ScheduleRepository;
import com.irctc.project.repository.StationRepository;
import com.irctc.project.repository.StationReturnRepository;
import com.irctc.project.repository.TrainRepository;
import com.irctc.project.repository.TrainReturnRepository;

@Service
public class StationReturnService {

	@Autowired
    StationReturnRepository sRepo;
	
	@Autowired
	TrainReturnRepository tRepo;
	
	@Autowired
	ScheduleRepository schRepo;

	public StationReturnService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StationReturn addStationWithTrains(StationReturnRequest stationreturnrequest) {
		StationReturn stationreturn=new StationReturn();
		stationreturn.setStationId(stationreturnrequest.stationId);
		stationreturn.setStop(stationreturnrequest.stop);
		stationreturn.setTrains(stationreturnrequest.trains
				.stream().map(trains->{
					TrainReturn t=trains;
					if(t.getTrainId()>0) {
						t=tRepo.findById(t.getTrainId());
					}
					t.addStation(stationreturn);
					return t;
					
				})
				.collect(Collectors.toList()));
		return sRepo.save(stationreturn);
	}
		
public List<StationTrain> getStationReturnWithTrain(Long id){
		
		return sRepo.fetchStation(id);
	}	
	
	
}
