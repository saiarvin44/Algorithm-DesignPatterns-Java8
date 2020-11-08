package algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 10, 6, 5, 2};
        int n = arr.length;
        int leader = arr[n - 1];
        List<Integer> ans = new ArrayList<>();
        ans.add(leader);
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > leader) {
                leader = arr[i];
                ans.add(arr[i]);
            }
        System.out.println(ans);
    }
}
