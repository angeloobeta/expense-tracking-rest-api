package com.example.expense_tracking_rest_api.repositories;

import com.example.expense_tracking_rest_api.domain.User;
import com.example.expense_tracking_rest_api.exception.ExpenseTrackingAuthException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    // SQL statements for performing operations
    private static final String SQL_CREATE = "INSERT INTO Expense";

    @Override
    public Integer createUser(String firstName, String lastName, String email, String password) throws ExpenseTrackingAuthException {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws ExpenseTrackingAuthException {
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }
}
