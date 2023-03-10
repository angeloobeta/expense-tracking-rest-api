package com.example.expense_tracking_rest_api.multi_thread;

 public class MultiThread extends  Thread{
     @Override
 public void run(){
     System.out.println("The current thread =====> " + currentThread().getName() + "Priority level is  "+ currentThread().getId());
 }
}
