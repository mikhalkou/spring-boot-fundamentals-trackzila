package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.entity.Ticket;
import com.mikhalkou.pluralsight.spring.trackzila.exception.*;
import com.mikhalkou.pluralsight.spring.trackzila.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final TicketService ticketService;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) throws ApplicationNotFoundException {
        return applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException("Application with id " + id + " is not exist."));
    }

    @Override
    public void deleteApplication(long id) throws ApplicationNotFoundException, ApplicationHasTicketsException {
        if (applicationRepository.existsById(id)) {
            /* TODO: implement with SQL COUNT (or a lazy collection).
            As app deletion is not a frequent operation decided to not optimize for now */
            List<Ticket> tickets = ticketService.listTickets(findApplication(id));
            if (tickets.isEmpty()) {
                applicationRepository.deleteById(id);
            } else {
                throw new ApplicationHasTicketsException("Application #" + id + " has " + tickets.size() + " ticket(s). Please remove them first.");
            }
        } else {
            throw new ApplicationNotFoundException("Application with id " + id + " is not exist.");
        }
    }

    @Override
    public Application createApplication(Application app) throws ApplicationEmptyNameException, CreateEntityIdNotEmptyException, ApplicationNameAlreadyExistsException {
        if (app.getId() == null) {
            return doSaveApp(app);
        } else {
            throw new CreateEntityIdNotEmptyException("Application entity id is not empty. Creation with a defined ID is not allowed.");
        }
    }

    @Override
    public Application updateApplication(Application app) throws ApplicationNotFoundException, ApplicationEmptyNameException, ApplicationNameAlreadyExistsException {
        if (applicationRepository.existsById(app.getId())) {
            return doSaveApp(app);
        } else {
            throw new ApplicationNotFoundException("Application with id " + app.getId() + " is not exist.");
        }
    }

    private Application doSaveApp(Application app) throws ApplicationNameAlreadyExistsException, ApplicationEmptyNameException {
        if (app.getName() != null && !app.getName().isBlank()) {
            if (!applicationRepository.existsByName(app.getName())) {
                return applicationRepository.save(app);
            } else {
                throw new ApplicationNameAlreadyExistsException("Application with name '" + app.getName() + "' already exists.");
            }
        } else {
            throw new ApplicationEmptyNameException();
        }
    }
}
