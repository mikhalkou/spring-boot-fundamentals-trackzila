package com.mikhalkou.pluralsight.spring.trackzila.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    @Column(name = "app_name", nullable = false, unique = true)
    private String name;

    @Column(length = 2000)
    private String description;
    private String owner;

    public Application(String name, String description, String owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }
}
