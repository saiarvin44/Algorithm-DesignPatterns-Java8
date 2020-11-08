package Java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class GenericStream {
    public static void main(String[] args) {
        System.out.println("Even numbers : ");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        int sum = numbers.stream().reduce(0, (a,b) -> a+b);
        int sumAgain = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers : "+sum);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println("Word lengths : " + wordLengths);

        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(("")))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println("Unique characters : " + uniqueCharacters);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println("All possible pairs : " + pairs);

        Map<Boolean, List<Integer>> partitionedPrime = IntStream.rangeClosed(2, 100)
                .boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
        System.out.println("Partioned prime : " + partitionedPrime);
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int)Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate%i == 0);
    }

}
