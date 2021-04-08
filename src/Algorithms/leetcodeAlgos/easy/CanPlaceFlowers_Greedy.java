package Algorithms.leetcodeAlgos.easy;

public class CanPlaceFlowers_Greedy {
  public static void main(String[] args) {
    System.out.print(canPlaceFlowers(new int[] {1, 0, 0, 0, 1, 0, 0}, 2));
  }

  public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    int i = 0, count = 0;
    while (i < flowerbed.length) {
      if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        count++;
      }
      i++;
    }
    return count >= n;
  }
}
