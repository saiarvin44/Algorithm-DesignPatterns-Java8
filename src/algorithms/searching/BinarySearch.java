package algorithms.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60};
        int pos = binarySearch(arr, 20);
        int posAgain = binarySearchRecursive(arr, 0, arr.length - 1, 20);
        System.out.println(posAgain);
    }

    private static int binarySearchRecursive(int[] arr, int low, int high, int x) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == x) return mid;
        else if (arr[mid] > x)
            return binarySearchRecursive(arr, low, mid - 1, x);
        else
            return binarySearchRecursive(arr, mid + 1, high, x);
    }

    private static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
