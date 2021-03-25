package Algorithms.arrays;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Algo1 {
    public static void main(String[] args) {
        String ans = "";
        long val=0;
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        IntStream stream = IntStream.range(1,1000);
        for(long i=1; i<Math.pow(10,3); i++) {
            for(long j=1; j<=i; j++)
            {
                val = getCondition(j) + getCondition(i);
                if(val > n)
                    break;
                else if (val==n && val>n/2)
                    ans = "TRUE";
            }
        }
        if(ans.isBlank() || ans.isEmpty())
            ans = "FALSE";
        System.out.println(ans);
    }

    private static long getCondition(long a){
        return a*(a+1)/2;
    }
}
