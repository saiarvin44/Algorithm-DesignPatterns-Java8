package algorithms.searching;

public class SingleRepeatingArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, 3, 2, 2};
        int[] arr2 = new int[]{1, 3, 2, 4, 6, 5, 7, 3};
        int num = repeatingElt(arr, arr.length);
        int num2 = efficientRepeatingElt(arr2, arr2.length);
        System.out.println(num2);
    }

    private static int repeatingElt(int[] arr, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;
        for (int i = 0; i < n; i++) {
            if (visited[arr[i]])
                return arr[i];
            visited[arr[i]] = true;
        }
        return -1;
    }

    private static int efficientRepeatingElt(int[] arr, int n) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
