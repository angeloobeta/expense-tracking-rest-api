package com.example.expense_tracking_rest_api.multi_thread;

import java.util.Random;

import static java.lang.Thread.currentThread;

public class ThreadJoin implements Runnable{

    private  int id;

    public ThreadJoin(int id) {
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("Workers " + id + currentThread().getName());
        // simulate some work by sleeping for a random amount of time

        try{
            Thread.sleep((long) (Math.random()* 500));
            System.out.println("Workers inside try catch block" + id + currentThread().getName());
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        }
        System.out.println("Worker " + id + " finished");
    }
}
