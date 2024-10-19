package com.danielshawver.reminder.exception;

import com.danielshawver.reminder.models.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ReminderExceptionHandler {

    @ExceptionHandler(NoCustomerFoundException.class)
    public ResponseEntity<ErrorDetails> noCustomerFoundHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Did not find customer in database.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
