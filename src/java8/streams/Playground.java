package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Playground {
    public static void main(String[] args) {
        List<Dish> dishList = Arrays.asList(
                new Dish("salmon", false, 450, Dish.Type.FISH),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT)
        );

        List<String> lowCalorieDishes = dishList.stream().filter(dish -> dish.getCalories() > 300).limit(3).map(Dish::getName).collect(Collectors.toList());
        System.out.println(lowCalorieDishes);

        // We can perform grouping based on some value like dish type
        Map<Dish.Type, List<Dish>> groupByDishType = dishList.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(groupByDishType);

        // Get distinct dishes
        List<String> distinct = dishList.stream().distinct().map(Dish ::getName).collect(Collectors.toList());
        System.out.println(distinct);
    }

    static class Fruit {
        private String name;
        public Fruit(String name) {
            this.name = name;
        }
        public String getName() {
            return this.getName();
        }
    }
}
