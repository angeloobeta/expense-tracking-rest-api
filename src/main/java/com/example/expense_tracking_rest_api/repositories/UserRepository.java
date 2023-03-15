package com.example.expense_tracking_rest_api.repositories;

import com.example.expense_tracking_rest_api.domain.User;
import com.example.expense_tracking_rest_api.exception.ExpenseTrackingAuthException;

public interface UserRepository {
    Integer createUser(String firstName, String lastName, String email, String password) throws ExpenseTrackingAuthException;

    User findByEmailAndPassword(String email, String password) throws ExpenseTrackingAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
