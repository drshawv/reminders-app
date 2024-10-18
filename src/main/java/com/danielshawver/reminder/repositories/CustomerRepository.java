package com.danielshawver.reminder.repositories;

import com.danielshawver.reminder.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

