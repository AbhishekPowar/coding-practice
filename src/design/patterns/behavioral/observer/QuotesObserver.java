package design.patterns.behavioral.observer;

public class QuotesObserver implements Observer {
    private String name;
    QuotesObserver(String name) {
        this.name = name;
    }
    public void update(String quote) {
        System.out.println(this.name+", Today's Quote: "+ quote);
    }
}
