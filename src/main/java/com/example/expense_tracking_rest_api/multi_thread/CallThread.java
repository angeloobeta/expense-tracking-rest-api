package com.example.expense_tracking_rest_api.multi_thread;

import java.util.concurrent.CountDownLatch;

public class CallThread {
    int numberOfThread = 10;
    CountDownLatch latch = new CountDownLatch(numberOfThread);

    public void execute() throws InterruptedException {
        for(int i=0; i < numberOfThread; i++){
            MultiThread thread = new MultiThread(latch);
            thread.start();
        }
        latch.await();
        System.out.println("All threads have completed their tasks ");
    }


}
