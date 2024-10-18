package com.danielshawver.reminder.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String defaultEmail;

    private String oauthUniqueId;

    private String oauthServiceName;

    private Customer() {}

    public Customer(String firstName, String lastName, String defaultEmail, String oauthUniqueId, String oauthServiceName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.defaultEmail = defaultEmail;
        this.oauthUniqueId = oauthUniqueId;
        this.oauthServiceName = oauthServiceName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDefaultEmail() {
        return defaultEmail;
    }

    public String getOauthUniqueId() {
        return oauthServiceName;
    }

    public String getOauthServiceName() {
        return oauthServiceName;
    }

    @OneToMany(mappedBy = "customer")
    private List<Reminder> reminders;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", defaultEmail='" + defaultEmail + '\'' +
                ", oauthUniqueId='" + oauthUniqueId + '\'' +
                ", oauthServiceName='" + oauthServiceName + '\'' +
                '}';
    }
}

