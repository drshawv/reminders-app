package com.danielshawver.reminder.controllers;

import com.danielshawver.reminder.models.Customer;
import com.danielshawver.reminder.repositories.ReminderRepository;
import com.danielshawver.reminder.services.CustomerService;
import com.danielshawver.reminder.services.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ReminderController {

    @GetMapping("/")
    public String home(Authentication authentication);

    @GetMapping("/reminder")
    public String createReminderGet();

    @PostMapping("/reminder")
    public String createReminderPost(@RequestParam String email,
                                     @RequestParam String message);
}
