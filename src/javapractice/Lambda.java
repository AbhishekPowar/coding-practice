package javapractice;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

interface Predic<T> {
    boolean test(T t);

    default Predic<T> and(Predic<T> p2) {
        Objects.requireNonNull(p2);
        return (p) -> test(p) && p2.test(p);
    }
}

public class Lambda {
    public static void main(String[] args) {
        Predic<String> p1 = (s -> s.length() > 10);
        Predic<String> p2 = (s -> s.length() < 15);

        String s1 = "Hello World";

        System.out.println(p1.and(p2).test(s1));

        List<String> names = Arrays.asList("ashif", "ali");

        names.parallelStream();
    }
}
