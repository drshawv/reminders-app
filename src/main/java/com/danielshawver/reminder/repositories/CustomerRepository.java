package com.danielshawver.reminder.repositories;

import com.danielshawver.reminder.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByOauthUniqueIdAndOauthServiceName(String oauthUniqueId, String oauthServiceName);
}

