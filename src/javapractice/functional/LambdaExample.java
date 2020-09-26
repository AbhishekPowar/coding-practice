package javapractice.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {

    static class Apple {
        enum Color { RED, GREEN, YELLOW};
        private Color color;
        private int weight;

        public Apple(Color color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color=" + color +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(Apple.Color.RED, 100), new Apple(Apple.Color.RED, 150), new Apple(Apple.Color.GREEN, 200));

        Predicate<Apple> redApples = (a) -> Apple.Color.RED.equals(a.getColor());
        Predicate<Apple> heavyApple = (a) -> a.getWeight() >= 150;

        System.out.println(filter(appleList, redApples));
        System.out.println(filter(appleList, heavyApple));
    }

    public static <T> Collection<T> filter(Collection<T> inventory, Predicate<T> filter) {
        List<T> items = new ArrayList<>();

        for(T item: inventory) {
            if(filter.test(item))
                items.add(item);
        }
        return items;
    }
}
