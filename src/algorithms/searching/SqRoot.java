package algorithms.searching;

public class SqRoot {
    public static void main(String[] args) {
        int root = sqRoot(10);
    }

    private static int sqRoot(int x) {
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sq = mid * mid;
            if (sq == x)
                return mid;
            if (sq > mid)
                high = mid - 1;
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
