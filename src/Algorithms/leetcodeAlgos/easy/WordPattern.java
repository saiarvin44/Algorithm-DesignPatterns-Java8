package Algorithms.leetcodeAlgos.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordPattern {
  public static void main(String[] args) {
    System.out.println(wordPattern("abba", "dog cat cat dog"));
  }

  public static boolean wordPattern(String pattern, String s) {
    String[] splitS = s.split("\\s+");
    if (pattern.length() != splitS.length) return false;
    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      if (map.containsKey(pattern.charAt(i))) {
        String value = map.get(pattern.charAt(i));
        if (!value.equalsIgnoreCase(splitS[i])) return false;
      } else {
        Stream<Object> key;
        String compareString = splitS[i];
        key =
            map.entrySet().stream()
                .filter(entry -> compareString.equals(entry.getValue()))
                .map(Map.Entry::getKey);
        if (key.count() != 0) return false;
      }
      map.put(pattern.charAt(i), splitS[i]);
    }
    return true;
  }
}
