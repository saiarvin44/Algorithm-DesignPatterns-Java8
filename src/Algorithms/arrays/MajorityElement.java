package Algorithms.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 8, 6, 6, 6, 6};
        int majority = majorityElement1(arr, arr.length);
        int majorityAgain = majorityElement2(arr, arr.length);
        System.out.println(majorityAgain);
    }

    private static int majorityElement2(int[] arr, int length) {
        int res = 0;
        int count = 1;

        // Find a candidate
        for (int i = 0; i < length; i++) {
            if (arr[res] == arr[i])
                count++;
            else count--;
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // Check if the candidate is actually a majority element
        count = 0;
        for (int i = 0; i < length; i++)
            if (arr[res] == arr[i])
                count++;
        if (count <= length / 2)
            res = -1;
        return res;
    }

    private static int majorityElement1(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            int count = 1;
            for (int j = i + 1; j < length; j++)
                if (arr[i] == arr[j])
                    count++;
            if (count > length / 2)
                return i;
        }
        return -1;
    }
}
