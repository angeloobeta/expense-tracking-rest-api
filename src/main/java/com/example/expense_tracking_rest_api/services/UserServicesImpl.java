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
        // Make the email to lowercase
        if(email != null) email = email.toLowerCase();
        User user = userRepository.findByEmailAndPassword(email, password);
        return  user;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws ExpenseTrackingAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
//        System.out.println("This is the email address ==> "+ email.toString());
//        System.out.println("This is the firstName address ==> "+ firstName);
//        System.out.println("This is the password address ==> "+ password);
        if(!pattern.matcher(email.toString()).matches()) throw new ExpenseTrackingAuthException("Invalid email format");

        // get count by email
        Integer countByEmail = userRepository.getCountByEmail(email);
        if(countByEmail > 0) throw  new ExpenseTrackingAuthException("Email is already in user");

        // call repository.create
        Integer userId = userRepository.createUser(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
}
