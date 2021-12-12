package com.mikhalkou.pluralsight.spring.trackzila.web;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;
import com.mikhalkou.pluralsight.spring.trackzila.exception.*;
import com.mikhalkou.pluralsight.spring.trackzila.service.ApplicationService;
import com.mikhalkou.pluralsight.spring.trackzila.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> retrieveApplication(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(applicationService.findApplication(id));
        } catch (ApplicationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/applications/{id}")
    public ResponseEntity deleteApplication(@PathVariable("id") Long id) {
        try {
            applicationService.deleteApplication(id);
            return ResponseEntity.noContent().build();
        } catch (ApplicationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (ApplicationHasTicketsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PostMapping(value = "/applications", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Application> retrieveApplication(@RequestBody Application app) {
        try {
            return ResponseEntity.ok(applicationService.createApplication(app));
        } catch (ApplicationEmptyNameException | CreateEntityIdNotEmptyException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (ApplicationNameAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping(value = "/applications/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Application> updateApplication(@PathVariable("id") Long id, @RequestBody Application app) {
        try {
            if (app.getId() == null) {
                app.setId(id);
            }
            if (app.getId().equals(id)) {
                return ResponseEntity.ok(applicationService.updateApplication(app));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id in path " + id + " does not match body id " + app.getId());
            }
        } catch (ApplicationEmptyNameException | ApplicationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (ApplicationNameAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<Iterable<Ticket>> retrieveTickets() {
        return ResponseEntity.ok(ticketService.listTickets());
    }
}
