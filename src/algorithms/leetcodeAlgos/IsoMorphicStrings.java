package algorithms.leetcodeAlgos;

import java.util.Map;
import java.util.TreeMap;

public class IsoMorphicStrings {
  public static void main(String[] args) {
    System.out.print(isIsomorphic("ab", "ac"));
  }

  public static boolean isIsomorphic(String s, String t) {
    Map<Character, Integer> sMap = new TreeMap<>();
    Map<Character, Integer> tMap = new TreeMap<>();
    Map<Character, Character> map = new TreeMap<>();
    if (s.equals(t)) return true;
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), t.charAt(i));
      if (map.get(s.charAt(i)) != t.charAt(i)) return false;

      if (sMap.containsKey(s.charAt(i))) sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
      else sMap.put(s.charAt(i), 1);

      if (tMap.containsKey(t.charAt(i))) tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
      else tMap.put(t.charAt(i), 1);
    }
    if (sMap.size() != tMap.size()) return false;
    return true;
  }
}
