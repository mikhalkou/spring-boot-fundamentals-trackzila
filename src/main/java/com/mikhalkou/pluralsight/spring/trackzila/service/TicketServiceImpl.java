package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;
import com.mikhalkou.pluralsight.spring.trackzila.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public Iterable<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> listTickets(Application application) {
        return ticketRepository.findAllByApplication(application);
    }
}
