package com.example.expense_tracking_rest_api.controller;

import com.example.expense_tracking_rest_api.data.DataStore;
import com.example.expense_tracking_rest_api.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    DataStore db =  new DataStore();
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
        return db.getUserByName(q);
        }

    @GetMapping("/searchById")
    public User searchById(@RequestParam String id){
        return db.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/searchByName/{name}")
    public User searchByName(@PathVariable String name){
        return db.getUserByName(name);
        }
    @GetMapping("/searchByAge/{age}")
    public User searchByAge(@PathVariable String age){
        return db.getUserByAge(Integer.parseInt(age));
        }

        @GetMapping("/all-users")
    public List<User> getAllUser(){
        return db.getAllUsers();
        }
}


// TODO: Why does it keep returning the first object
// TODO: Why does it return the first object even without the parameter
// TODO: Refactor the whole code base
