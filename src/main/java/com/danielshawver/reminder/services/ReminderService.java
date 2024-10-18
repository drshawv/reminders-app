package com.danielshawver.reminder.services;

import com.danielshawver.reminder.models.Customer;
import com.danielshawver.reminder.models.Reminder;
import com.danielshawver.reminder.repositories.ReminderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Transactional
    public void createReminder(String email, String message, Customer customer) {

        Reminder reminder = new Reminder(email, message, customer);

        reminderRepository.save(reminder);

        System.out.println(reminderRepository.findAll());
    }
}
