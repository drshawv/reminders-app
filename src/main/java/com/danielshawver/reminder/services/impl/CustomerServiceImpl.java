package com.danielshawver.reminder.services.impl;

import com.danielshawver.reminder.exception.NoIssuerException;
import com.danielshawver.reminder.models.Customer;
import com.danielshawver.reminder.repositories.CustomerRepository;
import com.danielshawver.reminder.services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.net.URL;
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

        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();

        OAuth2User user = authentication.getPrincipal();

        URL issuer = user.getAttribute("iss");

        if(issuer==null){
            throw new NoIssuerException();
        }

        return customerRepository.findByOauthUniqueIdAndOauthServiceName(
                authentication.getName(), issuer.toString());
    }

    public void createOAuthCustomer(){

        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();

        OAuth2User user = authentication.getPrincipal();

        URL issuer = user.getAttribute("iss");

        if(issuer==null){
            throw new NoIssuerException();
        }

        String firstName = user.getAttribute("given_name")!=null
                ? user.getAttribute("given_name") : "";

        String lastName = user.getAttribute("family_name")!=null
                ? user.getAttribute("family_name") : "";

        String defaultEmail = user.getAttribute("email")!=null
                ? user.getAttribute("email") : "";

        createCustomer(firstName, lastName, defaultEmail,
                authentication.getName(), issuer.toString());
    }

    public void createOAuthCustomerIfNotExists(){

        if (!oauthCustomerExists()) {
            createOAuthCustomer();
        }
    }
}
