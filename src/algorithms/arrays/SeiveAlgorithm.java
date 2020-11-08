package algorithms.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SeiveAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPrime(n);
    }

    private static void printPrime(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<n; i++)
        {
            if(isPrime[i])
                for(int j=2*i; j<=n; j=j+i)
                    isPrime[j] = false;
        }
        for(int i=2; i<=n; i++)
            if(isPrime[i])
                System.out.print(i + " ");
    }
}
