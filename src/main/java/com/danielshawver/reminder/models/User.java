package com.danielshawver.reminder.models;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private long id;

    private String name;

    private String defaultEmail;

}

