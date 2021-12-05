package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.exception.ApplicationNotFoundException;

public interface ApplicationService {
    Iterable<Application> listApplications();
    Application findApplication(long id) throws ApplicationNotFoundException;
}
