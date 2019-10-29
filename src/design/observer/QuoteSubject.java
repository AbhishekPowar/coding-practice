package design.observer;

import java.util.HashSet;
import java.util.Set;

public class QuoteSubject implements Subject{
    private String todayQuote = "Dummy Quote";
    private Set<Observer> observers;

    public void register(Observer observer) {
        if (observers == null) {
            observers = new HashSet<>();
        }

        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(todayQuote);
        }
    }

    public void updateQuote(String quote) {
        this.todayQuote = quote;
        System.out.println("Subject state changed!!");
        System.out.println("Notifying Observers");
        notifyObservers();
    }
}
