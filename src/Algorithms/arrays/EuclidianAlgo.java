package Algorithms.arrays;

import java.util.Scanner;

public class EuclidianAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = gcd(a,b);
        System.out.println("GCD " + gcd);
    }

    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
}
