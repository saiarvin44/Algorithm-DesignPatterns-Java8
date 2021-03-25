package Algorithms.arrays;

public class MaxConcsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 0, 1, 0};
        int res = consecutiveOnesSolution1(arr, arr.length);
        int resAgain = consecutiveOnesSolution2(arr, arr.length);
        System.out.println(resAgain);
    }

    private static int consecutiveOnesSolution2(int[] arr, int length) {
        int max = 0;
        int count=0;
        for(int i=0;i<length;i++){
            if(arr[i]==0)
                count=0;
            else{
                count++;
                max=Math.max(max,count);
            }
        }
        return max;
    }

    private static int consecutiveOnesSolution1(int[] arr, int length) {
        int max = 0;
        int count;
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 1)
                    count++;
                else break;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
