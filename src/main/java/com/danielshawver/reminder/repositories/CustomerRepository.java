package com.danielshawver.reminder.repositories;

import com.danielshawver.reminder.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByOauthUniqueIdAndOauthServiceName(String oauthUniqueId, String oauthServiceName);
}

