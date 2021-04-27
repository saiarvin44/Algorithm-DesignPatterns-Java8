package Algorithms.leetcodeAlgos.medium;

import java.util.*;

class BracketPairOfString {
  public static void main(String[] args) {
    String s = "hi(name)";
    List<List<String>> knowledge = Arrays.asList(Arrays.asList("a", "b"));
    evaluate(s, knowledge);
  }

  public static String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> map = new HashMap<>();
    StringBuilder ans = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    int start = Integer.MIN_VALUE;
    int end = Integer.MAX_VALUE;

    List<String> list = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      if (start == Integer.MIN_VALUE) start = i + 1;
      if (s.charAt(i) == '(') start = i + 1;
      if (s.charAt(i) == ')') end = i;
      if (end != Integer.MAX_VALUE) {
        list.add(s.substring(start, end));
        start = Integer.MIN_VALUE;
        end = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < knowledge.size(); i++)
      if (!map.containsKey(knowledge.get(i).get(0)))
        map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '(' && s.charAt(i) != ')') ans.append(s.charAt(i));
      if (s.charAt(i) == '(') {
        while (s.charAt(i) != ')') {
          i++;
          if (s.charAt(i) != ')') temp.append(s.charAt(i));
        }
        ans.append(map.getOrDefault(temp.toString(), "?"));
      }
      temp = new StringBuilder();
    }
    return ans.toString();
  }
}
