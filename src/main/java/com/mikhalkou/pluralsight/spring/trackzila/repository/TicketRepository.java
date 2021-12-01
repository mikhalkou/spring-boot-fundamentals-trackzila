package com.mikhalkou.pluralsight.spring.trackzila.repository;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
