package Algorithms.hashing;

import java.util.*;

public class CountFrequency {
  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>(Arrays.asList(10, 10, 20, 20, 30, 40));
    for (Integer x : list) map.put(x, map.getOrDefault(x, 0) + 1);
    for (Map.Entry<Integer, Integer> e : map.entrySet())
      System.out.print(e.getKey() + ":" + e.getValue() + " ");
  }
}
