package com.example.expense_tracking_rest_api.data;

import com.example.expense_tracking_rest_api.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

//    private final HashMap<String,String> store = new HashMap<String, String>();

    private List<User> userTable = new ArrayList<User>();

    public  DataStore() {
        userTable.add(new User(2, 28,"obeta"));
        userTable.add(new User(1, 27,"ifeanyichukwu"));
        userTable.add(new User(3, 29,"betabyte"));
        userTable.add(new User(4, 30,"cypher"));
//        store.put("Malachy", "Senior Dev");
//        store.put("BetaByte", "ML Engineer");
    }


    // Get all the users
     public List<User> getAllUsers(){
        return  userTable;
    }

    // Get user by ID
    public User getUserById(int id){
        for(User user: userTable){
            System.out.println(user);
            if(user.getId() == id) System.out.println(id); return  user;
        }
        return null;
    }

    // GET user by Name
    public User getUserByName(String name)
    {
        for(User user: userTable){
            if(user.getName() == name)
                System.out.println(name);
                return  user;
        }
        System.out.println("Failed to exe");
        return null;
    }

// GET user by Age
    public  User getUserByAge(int age){
        for(User user: userTable){
            if(user.getAge() == age) System.out.println(age); return  user;
        };
        return  null;
    }

//    public  String searchWord(String word){
//        return userTable.get(word);
//    }

}
