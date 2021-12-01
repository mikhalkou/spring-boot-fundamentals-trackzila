package com.mikhalkou.pluralsight.spring.trackzila.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String releaseDate;
    private String description;

    public Release(String releaseDate, String description) {
        this.releaseDate = releaseDate;
        this.description = description;
    }
}
