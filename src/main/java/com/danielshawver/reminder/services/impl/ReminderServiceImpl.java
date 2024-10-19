package com.danielshawver.reminder.services.impl;

import com.danielshawver.reminder.exception.NoCustomerFoundException;
import com.danielshawver.reminder.models.Customer;
import com.danielshawver.reminder.models.Reminder;
import com.danielshawver.reminder.repositories.ReminderRepository;
import com.danielshawver.reminder.services.CustomerService;
import com.danielshawver.reminder.services.ReminderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository reminderRepository;
    private final CustomerService customerService;

    public ReminderServiceImpl(ReminderRepository reminderRepository, CustomerService customerService) {
        this.reminderRepository = reminderRepository;
        this.customerService = customerService;
    }

    public void createReminder(String email, String message) {

        Optional<Customer> customer = customerService.getOauthCustomer();

        if (!customer.isPresent()) {
            throw new NoCustomerFoundException();
        }

        Reminder reminder = new Reminder(email, message, customer.get());
        reminderRepository.save(reminder);
    }
}
