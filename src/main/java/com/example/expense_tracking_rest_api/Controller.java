package com.example.expense_tracking_rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public  String sayHi(){
        return "Hello from the server";
    }
}
