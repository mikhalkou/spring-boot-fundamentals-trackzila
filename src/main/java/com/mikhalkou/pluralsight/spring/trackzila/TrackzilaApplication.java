package com.mikhalkou.pluralsight.spring.trackzila;

import com.mikhalkou.pluralsight.spring.trackzila.entity.Application;
import com.mikhalkou.pluralsight.spring.trackzila.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrackzilaApplication {
    private static final Logger logger = LoggerFactory.getLogger(TrackzilaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrackzilaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoJpa(ApplicationRepository repo) {
        return (args) -> {
            repo.save(new Application("Trackzilla", "Bug tracking application", "Incognito"));
            repo.save(new Application("TheApp", "An application", "Me"));

            for (Application app : repo.findAll()) {
                logger.info("Application: {}", app);
            }
        };
    }
}
