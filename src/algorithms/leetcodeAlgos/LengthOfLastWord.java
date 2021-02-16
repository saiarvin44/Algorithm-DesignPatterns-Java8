package algorithms.leetcodeAlgos;

public class LengthOfLastWord {
  public static void main(String[] args) {
    System.out.print(lengthOfLastWord("Hello World"));
  }

  public static int lengthOfLastWord(String s) {
    String[] arr = s.split(" ");
    if (arr.length == 0) return 0;
    else {
      String str = arr[arr.length - 1];
      return str.length();
    }
  }
}
