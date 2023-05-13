package com.example.expense_tracking_rest_api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@ComponentScan({"com.example.expense_tracking_rest_api.controller"})
public class ExpenseTrackingRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackingRestApiApplication.class, args);
    }

}
