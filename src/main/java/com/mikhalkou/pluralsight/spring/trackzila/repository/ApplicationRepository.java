package com.mikhalkou.pluralsight.spring.trackzila.repository;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
    boolean existsByName(String name);
}
