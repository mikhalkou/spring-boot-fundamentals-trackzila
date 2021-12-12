package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;

import java.util.List;

public interface TicketService {
    Iterable<Ticket> listTickets();
    List<Ticket> listTickets(Application application);
}
