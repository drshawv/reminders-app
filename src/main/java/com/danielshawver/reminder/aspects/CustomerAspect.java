package com.danielshawver.reminder.aspects;

import com.danielshawver.reminder.services.CustomerService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {

    private final CustomerService customerService;

    public CustomerAspect(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Before("execution(* com.danielshawver.reminder.controllers.*.*(..))")
    public void createCustomerIfNeeded() throws Throwable {
        System.out.println("In here");
        customerService.createOAuthCustomerIfNotExists();
    }
}
