package threading;

/**
 * Counter object, acts as a resource for Odd and Even Threads
 */
public class Counter {
    public final static int MAX = 20;
    private int counter;

    Counter(int initial)  {
        this.counter = initial;
    }
    public synchronized int getCounter() {
        return counter;
    }
    public synchronized void increment() {
        this.counter += 1;
    }
}
