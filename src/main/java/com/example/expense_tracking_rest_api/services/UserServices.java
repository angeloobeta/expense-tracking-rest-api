package com.example.expense_tracking_rest_api.services;

import com.example.expense_tracking_rest_api.domain.User;
import com.example.expense_tracking_rest_api.exception.ExpenseTrackingAuthException;

public interface UserServices {
    User validateUser(String email, String password) throws ExpenseTrackingAuthException;

    User registerUser(String firstName, String lastName, String email,String password) throws  ExpenseTrackingAuthException;
}
