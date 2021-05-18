package Algorithms.leetcodeAlgos.curatedAlgos;

public class MaxProfitByBuyingAndSellingAtMostTwice {
  public static void main(String[] args) {
    int[] price = new int[] {10, 20, 5, 75, 65, 80};
    int max = getMaxProfit(price);
  }

  private static int getMaxProfit(int[] price) {
    int profit = 0;
    for (int i = 0; i < price.length; i++) {
      int sub = price[i] - price[i - 1];
      if (sub > 0) profit += sub;
    }
    return profit;
  }
}
