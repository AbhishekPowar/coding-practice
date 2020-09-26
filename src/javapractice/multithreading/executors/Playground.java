package javapractice.multithreading.executors;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Playground {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Thread-"+ UUID.randomUUID().toString());
                return thread;
            }
        });
        executorService.submit(() -> System.out.println("Hello from executor "+Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("Hello from executor "+Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("Hello from executor "+Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("Hello from executor "+Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("Hello from executor "+Thread.currentThread().getName()));

        executorService.shutdown();
        System.out.println("Exit");
    }
}
