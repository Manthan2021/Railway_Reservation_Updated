package com.irctc.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irctc.project.model.Ticket;
import com.irctc.project.model.ticketpassenger;

public interface TicketRepository extends JpaRepository<Ticket,Long>{
	
@Query("select new com.irctc.project.model.ticketpassenger(t.tid,t.train_id,t.fromst,t.tost,t.deptdate,t.arrdate,t.deptTime,t.arrTime,p.pid,p.pname,p.age )from Ticket t INNER JOIN t.passenger p where t.tid= :id ")
 public List<ticketpassenger> fetchallTicket(@Param("id")Long id);
	
	
}
