package CoreJava.collections.leetcodeAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buddystrings {
  public static void main(String[] args) {
    System.out.print(buddyStrings("abab", "abab"));
  }

  public static boolean buddyStrings(String A, String B) {
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();
    String cmp1, cmp2;
    List<Integer> list = new ArrayList<>();
    Map<Character, Integer> map=new HashMap<>();

    if (a.length == b.length && a.length == 1) return false;
    if (a.length == 0 || b.length == 0) return false;
    if (a.length != b.length) return false;

    for (int i = 0; i < a.length; i++) {
        if(map.get(a[i])!=null) map.put(a[i], map.get(a[i])+1);
        else map.put(a[i],1);
      if (a[i] != b[i]) list.add(i);
    }

    if (list.isEmpty()) {
        for(Integer value:map.values())
          if(value>1)
            return true;

      //      char tmp = a[0];
      //      for (int i = 0; i < a.length; i++) if (a[i] != a[0]) returnFalse = true;
      //      if (!returnFalse) return true;
    }

    if (list.size() != 2) return false;
    else {
      char tmp = a[list.get(0)];
      a[list.get(0)] = a[list.get(1)];
      a[list.get(1)] = tmp;
      cmp1 = new String(a);
      cmp2 = new String(b);
      if (cmp1.equals(cmp2)) return true;
      else return false;
    }
  }
}
