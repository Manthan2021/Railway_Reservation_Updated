package com.irctc.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc.project.model.Consumer;
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long>{

	public Consumer findByEmail(String email);
	
	public Optional<Consumer> findItByEmail(String email);
}
