package com.danielshawver.reminder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

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
        return "listReminders.html";
    }

//    @PostMapping("/test")
//    public String testPost(){
//        System.out.println("testPost");
//        return "index.html";
//    }
}
