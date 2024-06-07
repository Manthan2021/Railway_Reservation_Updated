package com.irctc.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.project.model.Schedule;
import com.irctc.project.model.Station;
import com.irctc.project.model.StationRequest;
import com.irctc.project.model.StationTrain;
import com.irctc.project.model.Train;
import com.irctc.project.repository.ScheduleRepository;
import com.irctc.project.repository.StationRepository;
import com.irctc.project.repository.TrainRepository;

@Service
public class StationService {
	
	@Autowired
    StationRepository sRepo;
	
	@Autowired
	TrainRepository tRepo;
	
	@Autowired
	ScheduleRepository schRepo;
    
	public StationService() {}
	
	public Station addStationWithTrains(StationRequest stationrequest) {
		
		Station station=new Station();
		station.setStationId(stationrequest.stationId);
		station.setStop(stationrequest.stop);
		station.setTrains(stationrequest.trains
				.stream().map(trains->{
					Train t=trains;
					if(t.getTrainId()>0) {
						t=tRepo.findById(t.getTrainId());
					}
					t.addStation(station);
					return t;
				})
				.collect(Collectors.toList()));
				
		return sRepo.save(station);
		
	}
	
	public Schedule addSchedule(Schedule schedule) {
		Schedule s=new Schedule();
		s.setTrainId(schedule.getTrainId());
		s.setArrTime(schedule.getArrTime());
		s.setDeptTime(schedule.getArrTime());
		s.setStationId(schedule.getStationId());
		return schRepo.save(s);
		
	}
	
	public List<StationTrain> getStationWithTrain(Long id){
		
		return sRepo.fetchStation(id);
	}
	
	public List<Station> getStation(String id) {
		return sRepo.findByStop(id);
	}
	
	public List<Station> getallStations(){
		return sRepo.findAll();
	}
	

}
