package javapractice.multithreading.executors;

import java.util.function.IntConsumer;

public class CallbackStyleExample {

    public static void f(int x, IntConsumer consumer) {

    }

    public static void g(int y, IntConsumer consumer) {

    }

    public static void main(String[] args) {

        int x = 1337;
        Result result = new Result();

        f(x, (y) -> result.left = y);
        g(x, (y) -> result.right = y);
    }
}
