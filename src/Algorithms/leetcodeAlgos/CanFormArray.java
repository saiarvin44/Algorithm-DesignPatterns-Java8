package Algorithms.leetcodeAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanFormArray {
  public static void main(String[] args) {
    System.out.print(canFormArray(new int[] {3, 4, 8}, new int[][] {{3}, {5, 8}}));
  }

  public static boolean canFormArray(int[] arr, int[][] pieces) {
    Map<Integer, int[]> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < pieces.length; i++) map.put(pieces[i][0], pieces[i]);
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        for (int j = 0; j < map.get(arr[i]).length; j++) list.add(map.get(arr[i])[j]);
      }
    }
    for (int i = 0; i < arr.length; i++)
      if (list.size() != arr.length || arr[i] != list.get(i)) return false;
    return true;
  }
}
