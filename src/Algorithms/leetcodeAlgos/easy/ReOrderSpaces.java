package Algorithms.leetcodeAlgos.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReOrderSpaces {
  public static void main(String[] args) {
    System.out.println(reorderSpaces(" practice   makes   perfect"));
  }

  public static String reorderSpaces(String text) {
    if (text.length() == 1) return text;
    int count = 0;
    List<String> arr = new ArrayList<>(Arrays.asList(text.split("\\s+")));
    if (arr.get(0).equals("")) arr.remove("");
    int words = arr.size();

    if (words == 1) {
      int singleCount = 0;
      StringBuilder singleSpaceBuilder = new StringBuilder();
      StringBuilder singleAnsBuilder = new StringBuilder();
      for (int i = 0; i < text.length(); i++) if (text.charAt(i) == ' ') singleCount++;
      for (int i = 0; i < singleCount; i++) singleSpaceBuilder.append(" ");
      singleAnsBuilder.append(arr.get(0));
      singleAnsBuilder.append(singleSpaceBuilder.toString());
      return singleAnsBuilder.toString();
    }

    int split;
    for (int i = 0; i < text.length(); i++) if (text.charAt(i) == ' ') count++;
    split = count / (words - 1);
    int rem = count % (words - 1);
    StringBuilder spaceBuilder = new StringBuilder();
    StringBuilder ansBuilder = new StringBuilder();
    for (int i = 0; i < split; i++) spaceBuilder.append(" ");
    String space = spaceBuilder.toString();
    for (int i = 0; i < words; i++) {
      ansBuilder.append(arr.get(i));
      if (i != words - 1) ansBuilder.append(space);
    }
    spaceBuilder = new StringBuilder();
    for (int i = 0; i < rem; i++) spaceBuilder.append(" ");
    ansBuilder.append(spaceBuilder.toString());
    return ansBuilder.toString();
  }
}
