package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.exception.*;

public interface ApplicationService {
    Iterable<Application> listApplications();

    Application findApplication(long id) throws ApplicationNotFoundException;

    void deleteApplication(long id) throws ApplicationNotFoundException, ApplicationHasTicketsException;

    Application createApplication(Application app) throws ApplicationEmptyNameException, CreateEntityIdNotEmptyException, ApplicationNameAlreadyExistsException;

    Application updateApplication(Application app) throws ApplicationNotFoundException, ApplicationEmptyNameException, ApplicationNameAlreadyExistsException;
}
