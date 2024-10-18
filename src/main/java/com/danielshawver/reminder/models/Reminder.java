package com.danielshawver.reminder.models;

import jakarta.persistence.*;

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

    public Reminder(String email, String message, Customer customer) {
        this.email = email;
        this.message = message;
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}

