package Algorithms.arrays;

public class MaxLenEvenOdd {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 20, 6, 3, 8};
        int max = evenOddmethod1(arr, arr.length);
        System.out.println(max);
    }

    private static int evenOddmethod1(int[] arr, int length) {
        int count = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if ((isOdd(arr[i]) && isEven(arr[i - 1])) || ((isEven(arr[i])) && isOdd(arr[i - 1]))) {
                count++;
                res = Math.max(res, count);
            } else count = 1;
        }
        return count;
    }

    private static boolean isOdd(int elt) {
        if (elt % 2 == 0)
            return false;
        else
            return true;
    }

    private static boolean isEven(int elt) {
        if (elt % 2 == 0)
            return true;
        else
            return false;
    }
}
