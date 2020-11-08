package Java8.util.function;

import java.util.*;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        FunctionExample obj = new FunctionExample();

        // basic
        Function<String, Integer> func = x -> x.length();
        Integer apply = func.apply("SeeForYourself");
        System.out.println("Size of String : " + apply);

        // function chaining
        Function<String, Integer> func2 = x -> x.length();
        Function<Integer, Integer> func3 = x -> x * 2;
        Integer result = func2.andThen(func3).apply("SeeForYourself");
        System.out.println("Double the size of String : " + result);

        // List->Map
        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        Map<String, Integer> map = convertListToMap(list, x -> x.length());
        System.out.println("Map of Strings : " + map);

        // List->List
        List<String> list1 = mapList(list, obj::addArvind);
        System.out.println("List of Strings with arvind appended : ");
        list1.forEach(System.out::println);
    }

    private static <T, R> List<R> mapList(List<T> list, Function<T, R> func) {
        List<R> result = new ArrayList<>();
        for (T t : list)
            result.add(func.apply(t));
        return result;
    }

    private static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {
        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;
    }

    public String addArvind(String str) {
        return str + " Arvind";
    }
}
