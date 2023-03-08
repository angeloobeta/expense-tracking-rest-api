package com.example.expense_tracking_rest_api;

import java.util.HashMap;

public class DataStore {

    private final HashMap<String,String> store = new HashMap<String, String>();

    public DataStore() {
        store.put("Malachy", "Senior Dev");
        store.put("BetaByte", "ML Engineer");
    }

    public  String searchWord(String word){
        return store.get(word);
    }
}
