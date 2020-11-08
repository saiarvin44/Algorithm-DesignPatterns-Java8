package Java8.util.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {
    public static void main(String[] args) {
        // Simple Example
        BiFunction<Integer, Integer, Integer> func1 = (x1, x2) -> x1 + x2;
        Integer result1 = func1.apply(2, 4);
        BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);
        Double result2 = func2.apply(2, 4);
        BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);
        List<Integer> result3 = func3.apply(2, 4);

        // BiFunction<T,U,R> + Function<T,R>
        BiFunction<Integer, Integer, Double> func4 = (a, b) -> Math.pow(a, b);
        Function<Double, String> func5 = (input) -> "Result : " + String.valueOf(input);
        String result4 = func4.andThen(func5).apply(2, 4);
        System.out.println(result4);

        // multiple usecase of the same method implemented with generics
        // Take two Integers, pow it into a Double, convert Double into a String.
        String result5 = convert(2, 4,
                (a1, a2) -> Math.pow(a1, a2),
                r -> "Pow : " + String.valueOf(r));
        System.out.println(result5);


    }

    // second use case with generics
    public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> func1, Function<R1, R2> func2) {
        return func1.andThen(func2).apply(a1, a2);
    }
}
