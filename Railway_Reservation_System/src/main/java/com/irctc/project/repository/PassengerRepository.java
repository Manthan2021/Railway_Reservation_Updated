package com.irctc.project.repository;

import org.springframework.stereotype.Repository;
import com.irctc.project.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long>{

}
