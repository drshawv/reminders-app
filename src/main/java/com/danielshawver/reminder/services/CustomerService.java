package com.danielshawver.reminder.services;

import com.danielshawver.reminder.models.Customer;
import com.danielshawver.reminder.models.Reminder;
import com.danielshawver.reminder.repositories.CustomerRepository;
import com.danielshawver.reminder.repositories.ReminderRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean oauthCustomerExists() {
        return ! getOauthCustomer().isEmpty();
    }

    @Transactional
    public void createCustomer(String firstName, String lastName, String defaultEmail, String oauthUniqueId, String oauthServiceName) {

        Customer customer = new Customer(firstName, lastName, defaultEmail, oauthUniqueId, oauthServiceName);

        customerRepository.save(customer);

        System.out.println(customerRepository.findAll());
    }

    public List<Customer> getOauthCustomer() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return customerRepository.findByOauthUniqueIdAndOauthServiceName(
                authentication.getName(), "GOOGLE");
    }

    @Transactional
    public void createOAuthCustomer(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        createCustomer("DAN", "TEST", "drshawv@gmail.com",
                authentication.getName(), "GOOGLE");
    }

    @Transactional
    public void createOAuthCustomerIfNotExists(){

        if (!oauthCustomerExists()) {
            System.out.println("Customer does not exist");
            createOAuthCustomer();
        }
    }
}
