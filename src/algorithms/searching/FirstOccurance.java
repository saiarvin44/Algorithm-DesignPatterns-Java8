package algorithms.searching;

public class FirstOccurance {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 10, 20, 20};
        int first = firstOccurance(arr, arr.length, 20);
        int last = lastOccurance(arr, arr.length, 20);
        System.out.println(last);
    }

    private static int lastOccurance(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else {
                if (mid == n - 1 || arr[mid + 1] != arr[mid])
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    private static int firstOccurance(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
