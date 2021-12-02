package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();
}
