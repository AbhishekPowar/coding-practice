package threading;

public class Application {
    public static void main(String[] args) {
        Counter counter = new Counter(1);
        Printer printer = new Printer();

        Thread oddThread = new Thread(new OddThread(counter, printer), "Odd Thread");
        Thread evenThread = new Thread(new EvenThread(counter, printer), "Even Thread");

        oddThread.start();
        evenThread.start();


    }
}
