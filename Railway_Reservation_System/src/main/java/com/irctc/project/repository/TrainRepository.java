package com.irctc.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc.project.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long>{

	public Train findById(long id);
	
	
}
