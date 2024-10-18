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

@Controller
public class ReminderController {

    private final CustomerService customerService;

    private final ReminderService reminderService;

    public ReminderController(CustomerService customerService, ReminderService reminderService) {
        this.customerService = customerService;
        this.reminderService = reminderService;
    }

    @Autowired
    private ApplicationContext applicationContext;

    public void printBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @GetMapping("/")
    public String home(Authentication authentication) {
        System.out.println("home");

        System.out.println(authentication.getName());

        //printBeans();

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

        List<Customer> customer = customerService.getOauthCustomer();

        reminderService.createReminder(email, message, customer.get(0));

        return "listReminders.html";
    }
}
