package CoreJava.collections.leetcodeAlgos;

import java.util.*;

public class MostCommonWord {
  public static void main(String[] args) {
    String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] ban = new String[] {"hit"};

    String[] arr = s.split("\\s+");

    System.out.println(mostCommonWord(s, ban));
  }

  public static String mostCommonWord(String paragraph, String[] banned) {
    for (int i = 0; i < banned.length; i++) banned[i] = banned[i].toLowerCase();
    List<String> list = new ArrayList<>(Arrays.asList(banned));
    paragraph = paragraph.replace(',', ' ');
    paragraph = paragraph.replace('.', ' ');
    Map<String, Integer> map = new HashMap<>();
    String[] arr = paragraph.split("\\s+");
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i].toLowerCase())) map.put(arr[i].toLowerCase(), 1);
      else map.put(arr[i].toLowerCase(), map.get(arr[i].toLowerCase()) + 1);
    }
    int res = 0;
    String ans = "";
    for (Map.Entry<String, Integer> entry : map.entrySet())
      if (!list.contains(entry.getKey().toLowerCase()) && entry.getValue() > res) {
        res = entry.getValue();
        ans = entry.getKey();
      }

    return ans;
  }
}
