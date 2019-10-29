package design.observer;

public class Application {
    public static void main(String[] args) {
        QuoteSubject subject = new QuoteSubject();

        Observer o1 = new QuotesObserver("Observer 1");
        Observer o2 = new QuotesObserver("Observer 2");

        subject.register(o1);
        subject.register(o2);

        subject.updateQuote("Hello World");

        subject.updateQuote("God's delays are not god denials");
    }
}
