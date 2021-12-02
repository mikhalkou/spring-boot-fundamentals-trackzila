package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}
