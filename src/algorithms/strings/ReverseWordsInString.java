package algorithms.strings;

public class ReverseWordsInString {
  public static void main(String[] args) {
    String str = "Welcome to gfg";
    System.out.println(reverseWords(str));
  }

  private static String reverseWords(String str) {
    char[] strArray = str.toCharArray();
    int start = 0;
    for (int end = 0; end < str.length(); end++) {
      if (strArray[end] == ' ') {
        reverseIndividualWord(strArray, start, end - 1);
        start = end + 1;
      }
    }
    reverseIndividualWord(strArray, start, str.length() - 1);
    reverseIndividualWord(strArray, 0, str.length() - 1);
    return new String(strArray);
  }

  private static void reverseIndividualWord(char[] str, int start, int end) {
    char temp;
    while (start <= end) {
      temp = str[start];
      str[start] = str[end];
      str[end] = temp;
      start++;
      end--;
    }
  }
}
