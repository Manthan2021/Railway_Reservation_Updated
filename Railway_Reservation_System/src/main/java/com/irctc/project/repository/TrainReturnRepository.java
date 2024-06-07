package com.irctc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc.project.model.Train;
import com.irctc.project.model.TrainReturn;

@Repository
public interface TrainReturnRepository extends JpaRepository<TrainReturn,Long> {

	public TrainReturn findById(long id);
}
