package com.example.expense_tracking_rest_api;


import com.example.expense_tracking_rest_api.multi_thread.CallThread;
import com.example.expense_tracking_rest_api.multi_thread.CallThreadJoin;
import com.example.expense_tracking_rest_api.multi_thread.MultiThread;
import com.example.expense_tracking_rest_api.multi_thread.ThreadJoin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@ComponentScan({"com.example.expense_tracking_rest_api.controller"})
public class ExpenseTrackingRestApiApplication {

    public static void main(String[] args) throws InterruptedException {

        // Create an instance of the CallThread class
//        CallThread callThread = new CallThread();
//        callThread.execute();

        // Create an instance of the CallThreadJoin class
        CallThreadJoin threadJoin = new CallThreadJoin();
        threadJoin.execute();

        SpringApplication.run(ExpenseTrackingRestApiApplication.class, args);
    }

}
