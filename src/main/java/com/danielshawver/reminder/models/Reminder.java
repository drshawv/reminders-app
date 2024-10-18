package com.danielshawver.reminder.models;

import org.springframework.data.annotation.Id;

public class Reminder {

    @Id
    private long id;

    private String name;

    private String email;

    private String message;

}

