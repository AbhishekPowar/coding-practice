package threading;

/**
 * Thread to print odd numbers
 */
public class OddThread implements Runnable{
    private Printer printer;
    private Counter counter;

    OddThread(Counter counter, Printer printer) {
        this.counter = counter;
        this.printer = printer;
    }
    @Override
    public void run() {
        printer.printOdd(counter);
    }
}
