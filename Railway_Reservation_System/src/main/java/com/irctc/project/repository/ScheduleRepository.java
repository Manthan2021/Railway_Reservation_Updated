package com.irctc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.project.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{

}
