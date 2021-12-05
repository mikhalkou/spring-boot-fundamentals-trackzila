package com.mikhalkou.pluralsight.spring.trackzila.web;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;
import com.mikhalkou.pluralsight.spring.trackzila.exception.ApplicationNotFoundException;
import com.mikhalkou.pluralsight.spring.trackzila.service.ApplicationService;
import com.mikhalkou.pluralsight.spring.trackzila.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tza/api/v1")
@RequiredArgsConstructor
public class TrackzilaRestController {
    private final ApplicationService applicationService;
    private final TicketService ticketService;

    @GetMapping("/applications")
    public ResponseEntity<Iterable<Application>> retrieveApplications() {
        return ResponseEntity.ok(applicationService.listApplications());
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> retrieveApplication(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(applicationService.findApplication(id));
        } catch (ApplicationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<Iterable<Ticket>> retrieveTickets() {
        return ResponseEntity.ok(ticketService.listTickets());
    }
}
