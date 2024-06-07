package com.irctc.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irctc.project.model.Station;
import com.irctc.project.model.StationReturn;
import com.irctc.project.model.StationTrain;

public interface StationReturnRepository extends JpaRepository<StationReturn,Long> {
	
	public StationReturn findById(long id);
	
	@Query("select new com.irctc.project.model.StationTrain(s.stationId,s.stop,t.trainId,"
			+ "t.trainName,t.capacity,t.type) from StationReturn s join s.trains t where "
			+ "s.stationId= :id")
	List<StationTrain> fetchStation(@Param("id") Long id);

}
