package Algorithms.leetcodeAlgos.medium;

import java.util.*;

class SortCharacterByFrequency {
  public static void main(String[] args) {
    System.out.println(frequencySort("Tree"));
  }

  public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm) {
    List<Map.Entry<Character, Integer>> list = new LinkedList<>(hm.entrySet());

    Collections.sort(
        list,
        new Comparator<Map.Entry<Character, Integer>>() {
          public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
          }
        });

    // put data from sorted list to hashmap
    HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
    for (Map.Entry<Character, Integer> aa : list) {
      temp.put((Character) aa.getKey(), (Integer) aa.getValue());
    }
    return temp;
  }

  public static String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    Map<Character, Integer> sortedMap = sortByValue((HashMap<Character, Integer>) map);
    for (Map.Entry entry : sortedMap.entrySet()) {
      for (int i = 0; i < (Integer) entry.getValue(); i++)
        builder.append((Character) entry.getKey());
    }
    return builder.toString();
  }
}
