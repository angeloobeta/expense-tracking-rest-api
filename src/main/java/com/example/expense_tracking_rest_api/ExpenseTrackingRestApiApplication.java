package com.example.expense_tracking_rest_api;


import com.example.expense_tracking_rest_api.multi_thread.CallThread;
import com.example.expense_tracking_rest_api.multi_thread.MultiThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@ComponentScan({"com.example.expense_tracking_rest_api.controller"})
public class ExpenseTrackingRestApiApplication {

    public static void main(String[] args) throws InterruptedException {

        CallThread callThread = new CallThread();
        callThread.execute();

        SpringApplication.run(ExpenseTrackingRestApiApplication.class, args);
    }

}
