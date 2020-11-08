package Java8.streams;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamsForDish {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        long count = menu.stream().filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println("Count of dishes whose caory is more than 300 : " + count);

        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .skip(1)
                .collect(toList());
        System.out.println("Vegetarian dishes except french fries: " + vegetarianDishes);

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println("First Vegetarian dish : " + dish.getName()));

        long howManyDishes = menu.stream().collect(counting());
        System.out.println("Number of dishes : " + howManyDishes);

        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println("Most calorific dish : " + mostCalorieDish);

        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("Total calories : " + totalCalories);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println("Short menu : " + shortMenu);

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("Dishes by type : " + dishesByType);

        Map<Dish.Type, Map<String, List<Dish>>> dishesByTypeCalorificValue = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return "DIET";
                            else if (dish.getCalories() <= 700) return "NORMAL";
                            else return "FAT";
                        })
                ));
        System.out.println("nested Grouping : " + dishesByTypeCalorificValue);

        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println("Count of each dishes in each type : " + typesCount);

        Map<Dish.Type, Dish> mostCalorificType = menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(
                        maxBy(comparingInt(Dish::getCalories)),
                        Optional::get
                )));
        System.out.println("Most calorific dish in each type : " + mostCalorificType);

        Map<Boolean, List<Dish>> partitionedDishes = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println("Partitioned Dishes : " + partitionedDishes);
    }
}
