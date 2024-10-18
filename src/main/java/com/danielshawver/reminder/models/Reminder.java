package com.danielshawver.reminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reminder {

    @Id
    private Long id;

//    private String name;
//
//    private String email;
//
//    private String message;

    public Long getId() {
        return id;
    }
}

