package com.danielshawver.reminder.controllers.impl;

import com.danielshawver.reminder.controllers.ReminderController;
import com.danielshawver.reminder.services.CustomerService;
import com.danielshawver.reminder.services.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReminderControllerImpl implements ReminderController {

    private final ReminderService reminderService;

    public ReminderControllerImpl(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @Override
    public String home(Authentication authentication) {

        return "index.html";
    }

    @Override
    public String createReminderGet(){
        return "createReminder.html";
    }

    @Override
    public String createReminderPost(String email, String message){

        reminderService.createReminder(email, message);

        return "listReminders.html";
    }
}
