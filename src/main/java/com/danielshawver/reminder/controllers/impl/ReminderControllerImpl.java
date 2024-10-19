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

    private final CustomerService customerService;

    private final ReminderService reminderService;

    public ReminderControllerImpl(CustomerService customerService, ReminderService reminderService) {
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

    @Override
    public String home(Authentication authentication) {
        System.out.println("home");

        System.out.println(authentication.getName());

        //printBeans();

        return "index.html";
    }

    @Override
    public String createReminderGet(){
        System.out.println("createReminderGet");
        return "createReminder.html";
    }

    @Override
    public String createReminderPost(String email, String message){

        System.out.println("email: " + email);
        System.out.println("message: " + message);

        System.out.println("createReminderPost");

        reminderService.createReminder(email, message);

        return "listReminders.html";
    }
}
