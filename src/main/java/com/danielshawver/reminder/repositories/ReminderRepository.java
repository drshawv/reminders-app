package com.danielshawver.reminder.repositories;

import com.danielshawver.reminder.models.Reminder;
import org.springframework.data.repository.CrudRepository;

public interface ReminderRepository extends CrudRepository<Reminder, Long> {

}

