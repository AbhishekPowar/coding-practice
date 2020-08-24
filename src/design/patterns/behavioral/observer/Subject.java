package design.patterns.behavioral.observer;

public interface Subject {
    void register(Observer observer);
    void notifyObservers();
}
