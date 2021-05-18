package Algorithms.leetcodeAlgos.curatedAlgos;

class CompressedString {
  public static void main(String[] args) {
    char[] chars = new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    compress(chars);
    for (int i = 0; i < chars.length; i++) System.out.print(chars[i] + " ");
  }

  public static int compress(char[] chars) {
    StringBuilder builder = new StringBuilder();
    // Arrays.sort(chars);
    int count;
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      count = 0;
      while (i < chars.length && chars[i] == c) {
        count++;
        i++;
      }
      builder.append(c);
      builder.append(count);
      i--;
    }
    String ans = builder.toString();
    chars = new char[ans.length()];
    chars = ans.toCharArray();
    return ans.length();
  }
}
