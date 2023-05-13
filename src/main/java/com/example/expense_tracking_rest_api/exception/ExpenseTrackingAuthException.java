package com.example.expense_tracking_rest_api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExpenseTrackingAuthException extends RuntimeException{

    public ExpenseTrackingAuthException(String message){
        super(message);
    }
}
