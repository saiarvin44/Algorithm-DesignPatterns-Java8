package CoreJava.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListRemove {
  public static void main(String[] args) {
    int[] arr = new int[] {9, 4, 9, 8, 4};
    String[] str = new String[] {"abc", "bcd", "def"};
    str[0] = "";
    System.out.println(str[0].isEmpty());
    List<Integer> listFromArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
    List<Integer> list = Arrays.asList(9, 4, 9, 8, 4);
    listFromArr.remove(2);
    System.out.println(listFromArr.size());
    System.out.println(listFromArr.get(2));
  }
}
