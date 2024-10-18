package com.danielshawver.reminder.controllers;

import com.danielshawver.reminder.repositories.ReminderRepository;
import com.danielshawver.reminder.services.ReminderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/")
    public String home() {
        System.out.println("home");
        return "index.html";
    }

    @GetMapping("/reminder")
    public String createReminderGet(){
        System.out.println("createReminderGet");
        return "createReminder.html";
    }

    @PostMapping("/reminder")
    public String createReminderPost(@RequestParam String email,
                                     @RequestParam String message){

        System.out.println("email: " + email);
        System.out.println("message: " + message);

        System.out.println("createReminderPost");

        reminderService.createReminder(email, message);

        return "listReminders.html";
    }
}
