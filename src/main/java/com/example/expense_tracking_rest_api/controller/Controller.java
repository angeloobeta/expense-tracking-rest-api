package com.example.expense_tracking_rest_api.controller;

import com.example.expense_tracking_rest_api.data.DataStore;
import com.example.expense_tracking_rest_api.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {


    // GET APIs
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
    public User search(@RequestParam String name, @RequestParam String age, @RequestParam String id){
        return db.queryByAnyField(name,age, id);
        }

    @GetMapping("/searchById")
    public User searchById(@RequestParam String id){
        return db.getUserById(id);
    }

    @GetMapping("/searchByName/{name}")
    public User searchByName(@PathVariable String name){
        return db.getUserByName(name);
        }
    @GetMapping("/searchByAge/{age}")
    public User searchByAge(@PathVariable String age){
        return db.getUserByAge(Integer.parseInt(age));
        }

        @GetMapping("/all-users/{users}")
    public List<User> getAllUser(){
        return db.getAllUsers();
        }


        // POST APIs

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return db.addUser(user);
    }
}


// TODO: Why does it keep returning the first object
// TODO: Why does it return the first object even without the parameter
// TODO: Refactor the whole code base
// TODO: What's wrong with the forloop
