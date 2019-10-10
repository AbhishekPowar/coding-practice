package threading;

/**
 * Thread to print even numbers
 */
public class EvenThread implements Runnable{
    Printer printer;
    Counter counter;

    EvenThread(Counter counter, Printer printer) {
        this.counter = counter;
        this.printer = printer;
    }
    @Override
    public void run() {
        printer.printEven(counter);
    }
}
