package com.example.expense_tracking_rest_api.services;

import com.example.expense_tracking_rest_api.domain.User;
import com.example.expense_tracking_rest_api.exception.ExpenseTrackingAuthException;
import com.example.expense_tracking_rest_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

    @Autowired
    UserRepository userRepository;
    @Override
    public User validateUser(String email, String password) throws ExpenseTrackingAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws ExpenseTrackingAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches()) throw new ExpenseTrackingAuthException("Invalid email format");

        // get count by email
        Integer countByEmail = userRepository.getCountByEmail(email);
        if(countByEmail > 0) throw  new ExpenseTrackingAuthException("Email is already in user");

        // call repository.create
        Integer userId = userRepository.createUser(firstName, lastName, email, password);

        return userRepository.findById(userId);
    }
}
