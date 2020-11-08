package algorithms.arrays;

import java.util.Scanner;

public class PrimeNumberAndPrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean isPrime = isPrime(n);
        System.out.println("Is prime : " + isPrime);
        System.out.print("Prime factors : ");
        primeFactors(n);
    }

    private static void primeFactors(int n) {
        if (n<=1)
            return;
        for(int i=2; i*i<n; i++)
        {
            while(n%i == 0){
                System.out.print(i + " ");
                n = n/i;
            }
        }
        if(n>1)
            System.out.print(n);
    }

    private static boolean isPrime(int n) {
        for(int i=2; i*i<n; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
