package com.mikhalkou.pluralsight.spring.trackzila.service;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.exception.ApplicationNotFoundException;
import com.mikhalkou.pluralsight.spring.trackzila.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) throws ApplicationNotFoundException {
        return applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException("Application with id " + id + " is not exist."));
    }
}
