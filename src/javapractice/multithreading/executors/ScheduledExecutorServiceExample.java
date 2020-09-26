package javapractice.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void work1() {
        System.out.println("Hello from works1");
    }

    public static void work2() {
        System.out.println("Hello from work2");
    }

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        // do work1
        work1();
        // execute work2 after 10 seconds
        executorService.schedule(ScheduledExecutorServiceExample::work2, 10, TimeUnit.SECONDS);

        System.out.println("Shutting down started: "+System.currentTimeMillis());
        // shutting down
        executorService.shutdown();;
        System.out.println("Shutting down completed: "+ System.currentTimeMillis());


    }
}
