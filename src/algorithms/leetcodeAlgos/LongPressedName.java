package algorithms.leetcodeAlgos;

public class LongPressedName {
  public static void main(String[] args) {
    System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
  }

  public static boolean isLongPressedName(String name, String typed) {
    int j = 0;
    int single = 0;
    if (name.length() > typed.length()) return false;
    if (name.length() == 1) {
      if (name.charAt(0) != typed.charAt(0)) return false;
      single++;
      while (single < typed.length() - 1) {
        if (name.charAt(0) != typed.charAt(single)) return false;
        single++;
      }
    }
    for (int i = 0; i < name.length() - 1; i++) {
      if (name.charAt(i) != typed.charAt(j)) return false;
      if (name.charAt(i) != name.charAt(i + 1))
        while ((typed.charAt(j) == name.charAt(i)) && j < typed.length() - 1) j++;
      else j++;
    }
    for (int i = j; i < typed.length(); i++) {
      if (typed.charAt(i) != name.charAt(name.length() - 1)) return false;
    }
    return true;
  }
}
