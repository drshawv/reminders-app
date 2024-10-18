package com.danielshawver.reminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

//    private String name;
//
//    private String defaultEmail;

    public Long getId() {
        return id;
    }
}

