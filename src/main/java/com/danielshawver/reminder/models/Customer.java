package com.danielshawver.reminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String defaultEmail;

    public Long getId() {
        return id;
    }

    private Customer() {}

    public String getName() {
        return name;
    }

    public String getDefaultEmail() {
        return defaultEmail;
    }
}

