package com.example.expense_tracking_rest_api.resources;

import com.example.expense_tracking_rest_api.domain.User;
import com.example.expense_tracking_rest_api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserServices userServices;



    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap){
        String firstName = (String) userMap.get("firstName");
        String lastname = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userServices.registerUser("firstName", "lastName", "email", "password");
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        // Todo: generate jwt token and send from here
        // Create response entity object, passing in the map and the http status
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
