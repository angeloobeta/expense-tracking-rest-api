package com.example.expense_tracking_rest_api.multi_thread;

import java.util.concurrent.CountDownLatch;

public class MultiThread extends  Thread{
     private CountDownLatch latch;

     public MultiThread(CountDownLatch latch){
         this.latch = latch;
     }
     @Override
 public void run(){
         try{
             // Code to execute in this thread
             Thread.sleep(1000); // simulate some real work
             System.out.println("The current thread =====> " + currentThread().getName() + "Priority level is  "+ currentThread().getId());
             latch.countDown();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

}


