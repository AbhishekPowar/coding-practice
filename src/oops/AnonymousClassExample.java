package oops;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Button {
    void click();
}
public class AnonymousClassExample {

    public static void clickButton(Button button) {
        button.click();
    }

    public static Optional<String> modify(String name) {
        if(name == null)
            return Optional.empty();
        else
            return Optional.of(name + " Ali");
    }
    public static void main(String[] args) {
        Button button = new Button() {
            @Override
            public void click() {
                System.out.println("Anonymous Button Clicked");
            }
        };

        clickButton(button);
//        Button b1 = () -> System.out.println("Lambda Button Clicked");
        Optional<String> name = modify("Ashif");

        if (name.isPresent())
            System.out.println(name.get());
        IntStream intStream = IntStream.range(1, 10);
    }
}
