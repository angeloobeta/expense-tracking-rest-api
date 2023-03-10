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
    public User search(@RequestParam String name, @RequestParam String age, @RequestParam int id){
        return db.queryByAnyField(name,age, id);
        }

    @GetMapping("/searchById")
    public User searchById(@RequestParam int id){
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
@GetMapping("/searchById/{id}")
    public User searchId(@PathVariable int id){
        return db.getUserByAge(id);
        }

        @GetMapping("/all-users")
    public List<User> getAllUser(){
        return db.getAllUsers();
        }


        // POST APIs

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return db.addUser(user);
    }
}


// TODO: Why does it keep making the id zero
