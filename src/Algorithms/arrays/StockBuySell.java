package Algorithms.arrays;

public class StockBuySell {
    public static void main(String[] args) {
        int[] price = new int[]{1, 5, 3, 8, 12};
        int start = 0;
        int end = 4;
        // int profit = solution1(price, start, end);
        int sameProfit = solution2(price, price.length);
        System.out.println(sameProfit);
    }

    private static int solution2(int[] price, int length) {
        int profit = 0;
        for (int i = 1; i < length; i++) {
            if (price[i] > price[i - 1])
                profit += (price[i] - price[i - 1]);
        }
        return profit;
    }

    private static int solution1(int[] price, int start, int end) {
        if (start >= end)
            return 0;
        int profit = 0;
        for (int i = 0; i < end; i++)
            for (int j = i; j <= end; j++) {
                if (price[j] > price[i]) {
                    int currprofit = price[j] - price[i] +
                            solution1(price, start, i - 1) +
                            solution1(price, j + 1, end);
                    profit = Math.max(profit, currprofit);
                }
            }
        return profit;
    }


}
