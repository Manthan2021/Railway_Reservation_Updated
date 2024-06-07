package com.irctc.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irctc.project.model.Station;
import com.irctc.project.model.StationRequest;
import com.irctc.project.model.StationTrain;

public interface StationRepository extends JpaRepository<Station,Long> {

	public Station findById(long id);
	
	public List<Station> findByStop(String stop);
	
//	@Query("select new com.irctc.project.model.StationRequest(s.stationId,s.stop,t.trainId,"
//			+ "t.trainName,t.capacity,t.type) from Station s ")
//	public List<StationRequest> fetchStationInnerJoin();
	
	@Query("select new com.irctc.project.model.StationTrain(s.stationId,s.stop,t.trainId,"
			+ "t.trainName,t.capacity,t.type) from Station s join s.trains t where "
			+ "s.stationId= :id")
	List<StationTrain> fetchStation(@Param("id") Long id);
	
	
}
