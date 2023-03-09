package com.example.expense_tracking_rest_api.model;

public class User {
    public User(int userId, int age, String name) {
        this.userId = userId;
        this.age = age;
        this.name = name;
    }

    private    int userId;
    private    int age;
    private String name;


    public int getId() {
        return userId;
    }
//
    public String getName(){
        return User.this.name;
    }
//
    public int getAge(){
        return  User.this.age;
    }
}

