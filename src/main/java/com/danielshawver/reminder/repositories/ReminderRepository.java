package com.danielshawver.reminder.repositories;

import com.danielshawver.reminder.models.Reminder;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReminderRepository extends CrudRepository<Reminder, Long> {

//    @Query("SELECT * FROM reminder WHERE userId = :userId")
//    List<Reminder> findRemindersByUserId(String userId);
//
//    @Modifying
//    @Query("UPDATE reminder SET email = :email WHERE id = :id")
//    void updateEmail(long id, String email);

}

