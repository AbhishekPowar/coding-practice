package java8.collectors;

import java8.Employee;
import java8.collectors.Fruit.Color;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class Fruit {
    protected Integer weight;
    protected Color color;

    public enum Color { RED, ORANGE, GREEN }

    public Fruit(int weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}

class Apple extends Fruit {

    public Apple(int weight, Color color) {
        super(weight);
        System.out.println("Hello Apple");
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}

class Orange extends Fruit {

    public Orange(int weight, Color color) {
        super(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}

public class Example {

    static  Map<String, BiFunction<Integer, Color, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static void main(String[] args) {
        List<Employee> employees;

        Employee e1 = new Employee(1, "Ashif", 25);
        Employee e2 = new Employee(2, "Swapnil", 28);
        Employee e3 = new Employee(3, "Nikita", 25);

        employees = Arrays.asList(e1, e2, e3);

        Map<Integer, Long> e = employees.stream()
                .filter(employee -> employee.getAge() < 28)
                .collect(
                        Collectors.groupingBy(Employee::getAge, Collectors.counting())
                );


        System.out.println(giveMeFruit("apple", 123));

        // Let's say we have list of apples
        List<Apple> apples = new ArrayList<>();
        apples.add((Apple) map.get("apple").apply(2, Color.GREEN));
        apples.add((Apple) map.get("apple").apply(1, Color.RED));
        apples.add((Apple) map.get("apple").apply(1, Color.GREEN));
        apples.add((Apple) map.get("apple").apply(5, Color.ORANGE));

        /**
         * Now, how would you sort above list of apples ?
         * Option 1: using sort method present on list object, but how can you pass ordering strategy to sort method.
         * Sort method accepts Comparator<? super E> as an argument, that means we need to pass implementation of comparator.
         *
         * Approaches:
         * 1. Create our own class that implements comparator and override compare method.
         * 2. Pass Lambda as an argument to sort method, since Comparator is a functional interface
         * 3. Use existing implementation provided by Comparator Interface
         * */
        // Approach 1:
        apples.sort(new AppleComparator());
        System.out.println(apples);

        // Approach 2:
        apples.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(apples);
        // Approach 3:
        apples.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(apples);
        // OR
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(apples);


        apples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor, Comparator.reverseOrder()));
        System.out.println(apples);
    }

    public static Fruit giveMeFruit(String fruit, int weight) {
        return map.get(fruit).apply(weight, Color.GREEN);
    }
}

class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.weight);
    }
}
