package com.danielshawver.reminder.services;

import com.danielshawver.reminder.models.Customer;

import java.util.Optional;

public interface CustomerService {

    boolean oauthCustomerExists();

    void createCustomer(String firstName, String lastName, String defaultEmail, String oauthUniqueId, String oauthServiceName);

    Optional<Customer> getOauthCustomer();

    void createOAuthCustomer();

    void createOAuthCustomerIfNotExists();
}
