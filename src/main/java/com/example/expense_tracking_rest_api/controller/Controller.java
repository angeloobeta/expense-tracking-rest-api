package com.example.expense_tracking_rest_api.controller;

import com.example.expense_tracking_rest_api.data.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String home(){
        return "Home Page!";
    }

    @GetMapping("/hello")
    public  String sayHi(){
        return "Hello from the server";
    }

    @GetMapping("/search")
    public String searchWord(@RequestParam String q){
        DataStore db =  new DataStore();
        return db.searchWord(q);
        }
}
