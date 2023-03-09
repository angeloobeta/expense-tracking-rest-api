package com.example.expense_tracking_rest_api.controller;

import com.example.expense_tracking_rest_api.data.DataStore;
import com.example.expense_tracking_rest_api.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    @GetMapping("/")
    public String home(){
        return "Home Page!";
    }

    @GetMapping("/hello")
    public  String sayHi(){
        return "Hello from the server";
    }


    @GetMapping("/search")
    public User search(@RequestParam String q){
        DataStore db =  new DataStore();
        return db.getUserByName(q);
        }

    @GetMapping("/searchById")
    public User searchById(@RequestParam String id){
        DataStore db =  new DataStore();
        return db.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/searchByName")
    public User searchByName(@RequestParam String name){
            DataStore db =  new DataStore();
        return db.getUserByName(name);
        }
    @GetMapping("/searchByAge")
    public User searchByAge(@RequestParam String age){
        DataStore db =  new DataStore();
        return db.getUserByAge(Integer.parseInt(age));
        }

        @GetMapping("/all-users")
    public ArrayList<User> getAllUser(){
            DataStore db =  new DataStore();
        return db.getAllUsers();
        }
}


// TODO: Why does it keep returning the first object
// TODO: Why does it return the first object even without the parameter
// TODO: Refactor the whole code base
