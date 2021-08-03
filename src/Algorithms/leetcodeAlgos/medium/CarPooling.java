package Algorithms.leetcodeAlgos.medium;

class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] passengers = new int[1001];

        for (int[] trip : trips) {
            int passenger = trip[0], start = trip[1], end = trip[2];
            passengers[start] -= passenger;
            passengers[end] += passenger;
        }

        for (int passenger : passengers) {
            capacity += passenger;
            if (capacity < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] trips = new int[][]{
                {3, 2, 7},
                {3, 7, 9},
                {8, 3, 9}
        };
        System.out.println(carPooling(trips, 11));
    }
}