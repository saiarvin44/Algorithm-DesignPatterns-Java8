package Algorithms.leetcodeAlgos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class CountAndSay {
  public static void main(String[] args) {
    System.out.println(countAndSay(4));
  }

  public static String countAndSay(int n) {
    StringBuilder builder = new StringBuilder();
    Map<Integer, Integer> map = new LinkedHashMap<>();
    if (n == 0) return "0";
    if (n == 1) return "1";
    builder.append("1");
    for (int i = 1; i < n; i++) {
      map = count(map, builder);
      builder = build(map);
    }
    return builder.toString();
  }

  private static StringBuilder build(Map<Integer, Integer> map) {
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      builder.append(entry.getValue().toString());
      builder.append(entry.getKey().toString());
    }
    return builder;
  }

  private static Map<Integer, Integer> count(Map<Integer, Integer> map, StringBuilder builder) {
    map = new LinkedHashMap<>();
    Stack<Integer> stack = new Stack<>();
    int curr = Integer.valueOf(builder.toString());
    int rem;
    while (curr != 0) {
      rem = curr % 10;
      stack.push(rem);
      curr /= 10;
    }

    while (!stack.isEmpty()) {
      int val = stack.pop();
      if (!map.containsKey(val)) map.put(val, 1);
      else map.put(val, map.get(val) + 1);
    }

    return map;
  }
}
