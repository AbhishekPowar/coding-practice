package design.patterns.behavioral.command;

public interface ICommand<T> {
    void execute(T t);
}
