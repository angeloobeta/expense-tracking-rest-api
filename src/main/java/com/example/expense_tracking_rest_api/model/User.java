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


    public String getId() {
        return String.valueOf(userId);
    }
//
    public String getName(){
        return name;
    }
//
    public int getAge(){
        return age;
    }
}

