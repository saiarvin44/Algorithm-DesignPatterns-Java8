package CoreJava.strings;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = new String[] {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    int stringArrayLength = strs.length;
    String[] prefixStringArray = new String[strs.length-1];
    String prefix = "";
    int minLengthOfStringInStringArray = strs[0].length();
    int sizeOfPossiblePrefixes = 0;
    for (int i = 0; i < stringArrayLength; i++)
      minLengthOfStringInStringArray = Math.min(minLengthOfStringInStringArray, strs[i].length());
    for (int i = 1; i < stringArrayLength; i++) {
      prefix = "";
      for (int j = 0; j < minLengthOfStringInStringArray; j++) {
        if (strs[0].charAt(j) == strs[i].charAt(j)) prefix += strs[i].charAt(j);
      }
      if (!prefix.equalsIgnoreCase("")) prefixStringArray[sizeOfPossiblePrefixes++] = prefix;
      else prefixStringArray[sizeOfPossiblePrefixes++] = "";
    }
    int sizeOfLCMPrefix = prefixStringArray[0].length(), indexOfLCMPrefix = 0;
    for (int i = 0; i < prefixStringArray.length; i++) {
      if (prefixStringArray[i].length() < sizeOfLCMPrefix) {
        sizeOfLCMPrefix = prefixStringArray[i].length();
        indexOfLCMPrefix = i;
      }
    }
    if (prefixStringArray[0] == null) return "";
    return prefixStringArray[indexOfLCMPrefix];
  }
}
