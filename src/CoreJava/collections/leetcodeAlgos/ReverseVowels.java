package CoreJava.collections.leetcodeAlgos;

public class ReverseVowels {
  public static void main(String[] args) {
    System.out.print(reverseVowels("race a car"));
  }

  public static String reverseVowels(String s) {
    if (s.length() == 1) return s;
    // s = s.replaceAll("\\s", "");
    char[] c = s.toCharArray();
    char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    int l = 0, r = c.length - 1;
    while (l < r) {
      if (!(c[l] == 'a'
          || c[l] == 'e'
          || c[l] == 'i'
          || c[l] == 'o'
          || c[l] == 'u'
          || c[l] == 'A'
          || c[l] == 'E'
          || c[l] == 'I'
          || c[l] == 'O'
          || c[l] == 'U')) // !Chars.contains(vowels, c[l]))
      l++;
      if (!(c[r] == 'a'
          || c[r] == 'e'
          || c[r] == 'i'
          || c[r] == 'o'
          || c[r] == 'u'
          || c[r] == 'A'
          || c[r] == 'E'
          || c[r] == 'I'
          || c[r] == 'O'
          || c[r] == 'U')) // !Chars.contains(vowels, c[r]))
      r--;
      if ((c[l] == 'a'
              || c[l] == 'e'
              || c[l] == 'i'
              || c[l] == 'o'
              || c[l] == 'u'
              || c[l] == 'A'
              || c[l] == 'E'
              || c[l] == 'I'
              || c[l] == 'O'
              || c[l] == 'U')
          && (c[r] == 'a'
              || c[r] == 'e'
              || c[r] == 'i'
              || c[r] == 'o'
              || c[r] == 'u'
              || c[r] == 'A'
              || c[r] == 'E'
              || c[r] == 'I'
              || c[r] == 'O'
              || c[r] == 'U')) { // Chars.contains(vowels, c[l]) && Chars.contains(vowels, c[r])){
        swapChar(c, l, r);
        l++;
        r--;
      }
    }
    String str = String.valueOf(c);
    return str;
  }

  private static void swapChar(char[] c, int l, int r) {
    char tmp = c[l];
    c[l] = c[r];
    c[r] = tmp;
  }
}
