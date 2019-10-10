package threading;

/**
 * Printer thread to print numbers
 */
public class Printer {

    public synchronized void printOdd(Counter counter) {
        while (counter.getCounter() < Counter.MAX) {
            while(counter.getCounter() %2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
            System.out.println(counter.getCounter());
            counter.increment();
            notify();
        }
    }

    public synchronized void printEven(Counter counter)  {
        while (counter.getCounter() < Counter.MAX) {
            while(counter.getCounter() %2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
            System.out.println(counter.getCounter());
            counter.increment();
            notify();
        }
    }
}
