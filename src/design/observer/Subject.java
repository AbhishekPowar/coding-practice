package design.observer;

public interface Subject {
    void register(Observer observer);
    void notifyObservers();
}
