package javapractice.multithreading.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static int f(int x) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Hello from f");
        return x;
    }

    public static int g(int x) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Hello from g");
        return x;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int x = 1337;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        CompletableFuture<Integer> b = new CompletableFuture<>();

        CompletableFuture<Integer> c = a.thenCombine(b, Integer::sum);

        executorService.submit(() -> a.complete(f(x)));
        executorService.submit(() -> b.complete(g(x)));

        System.out.println(c.get());
        System.out.println("Hello after execution");
        executorService.shutdown();
    }
}
