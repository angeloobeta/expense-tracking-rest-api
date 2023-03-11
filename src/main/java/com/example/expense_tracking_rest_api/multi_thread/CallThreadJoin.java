package com.example.expense_tracking_rest_api.multi_thread;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;

public class CallThreadJoin {


    // create a list to hold our worker threads
    List<Thread> workers = new ArrayList<Thread>();

    // create and start 10 worker threads

    public void execute() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread worker = new Thread(new ThreadJoin(i));
            worker.start();
            workers.add(worker);
    }

        // wait for all worker threads to finish

        for(Thread worker: workers){
            worker.join();
        }

        // print a message indicating that all worker threads have finished
        System.out.println("All worker threads have finished"+  currentThread().getName());


    }

}
