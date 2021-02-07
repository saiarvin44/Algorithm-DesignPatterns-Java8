package CoreJava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListRemove {
  public static void main(String[] args) {
      int[] arr=new int[]{9,4,9,8,4};
      List<Integer> listFromArr= Arrays.stream(arr).boxed().collect(Collectors.toList());
      List<Integer> list = Arrays.asList(9,4,9,8,4);
      listFromArr.remove(0);
      System.out.print(listFromArr.size());

  }
}
