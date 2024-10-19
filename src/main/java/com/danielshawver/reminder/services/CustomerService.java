package com.danielshawver.reminder.services;

import com.danielshawver.reminder.models.Customer;

import java.util.Optional;

public interface CustomerService {

    public boolean oauthCustomerExists();

    public void createCustomer(String firstName, String lastName, String defaultEmail, String oauthUniqueId, String oauthServiceName);

    public Optional<Customer> getOauthCustomer();

    public void createOAuthCustomer();

    public void createOAuthCustomerIfNotExists();
}
