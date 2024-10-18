package com.danielshawver.reminder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String email;

    private String message;

    public Long getId() {
        return id;
    }

    private Reminder() {}

    public Reminder(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

