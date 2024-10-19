package com.danielshawver.reminder.services.impl;

import com.danielshawver.reminder.models.Customer;
import com.danielshawver.reminder.repositories.CustomerRepository;
import com.danielshawver.reminder.services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean oauthCustomerExists() {
        return getOauthCustomer().isPresent();
    }

    public void createCustomer(String firstName, String lastName, String defaultEmail, String oauthUniqueId, String oauthServiceName) {

        Customer customer = new Customer(firstName, lastName, defaultEmail, oauthUniqueId, oauthServiceName);

        customerRepository.save(customer);

        System.out.println(customerRepository.findAll());
    }

    public Optional<Customer> getOauthCustomer() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return customerRepository.findByOauthUniqueIdAndOauthServiceName(
                authentication.getName(), "GOOGLE");
    }

    public void createOAuthCustomer(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        createCustomer("DAN", "TEST", "drshawv@gmail.com",
                authentication.getName(), "GOOGLE");
    }

    public void createOAuthCustomerIfNotExists(){

        if (!oauthCustomerExists()) {
            System.out.println("Customer does not exist");
            createOAuthCustomer();
        }
    }
}
