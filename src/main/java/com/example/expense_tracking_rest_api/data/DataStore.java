package com.example.expense_tracking_rest_api.data;

import com.example.expense_tracking_rest_api.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

//    private final HashMap<String,String> store = new HashMap<String, String>();

    private final List<User> userTable = new ArrayList<User>();

    public DataStore() {
        userTable.add(new User(2, 28,"obeta"));
        userTable.add(new User(1, 27,"ifeanyichukwu"));
        userTable.add(new User(3, 29,"betabyte"));
        userTable.add(new User(4, 30,"cypher"));
    }


    // Get all the users
     public List<User> getAllUsers(){
        return  userTable;
    }

    // Get user by ID
    public User getUserById(String id){
        for(User user: userTable)
            if(user.getId().equals(id)) return  user;
        System.out.println("Failed to exe");
        return null;
    }

    // GET user by Name
    public User getUserByName(String name) {
        for(User user: userTable){
            if(user.getName().equals(name)) return user;

        }
        System.out.println("Failed to exe");
        return null;
    }

// GET user by Age
    public  User getUserByAge(int age){
        for(User user: userTable){
            if(user.getAge() == age) return  user;
        }
        System.out.println("Failed to exe");
        return  null;
    }


    public  User queryByAnyField(String name, String age, String id){
        String query = name;
        for(User user: userTable){
            if(user.getName().equals(name)  &&
                    user.getAge() == Integer.parseInt(age) &&
                    user.getId().equals(String.valueOf(id))) return user;
        }
        System.out.println("Failed to exe");
        return  null;
    }
}
