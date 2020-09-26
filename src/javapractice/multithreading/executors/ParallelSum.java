package javapractice.multithreading.executors;


import java.util.concurrent.*;

public class ParallelSum {

    public static int f(int x) throws InterruptedException {
        Thread.sleep(10000);
        return x;
    }

    public static int g(int y) throws InterruptedException {
        Thread.sleep(5000);
        return y;
    }

    public Future<Integer> a(ExecutorService executorService, int a) throws InterruptedException {
        return executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a;
        });
    }
    public Future<Integer> b(ExecutorService executorService, int a) throws InterruptedException {
        return executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a;
        });
    }

    public static void performSum_UsingTraditionalMethod() throws InterruptedException {
        Result result = new Result();
        Thread left = new Thread(() -> {
            try {
                result.left = f(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread right = new Thread(() -> {
            try {
                result.right = g(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        left.start();
        right.start();

        left.join();
        right.join();

        System.out.println(result.left + result.right);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Summing using traditional method of creating threads and joins
        // performSum_UsingTraditionalMethod();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> left = () -> f(10);
        Callable<Integer> right= () -> g(10);

        Future<Integer> leftFuture = executorService.submit(left);
        Future<Integer> rightFuture = executorService.submit(right);

        System.out.println(System.currentTimeMillis());
        System.out.println(leftFuture.get() + rightFuture.get());
        System.out.println(System.currentTimeMillis());
        executorService.shutdown();
    }
}

class Result {
    public int left;
    public int right;
}
