package Week2;

import java.util.*;
// Question 2
public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int[] F = new int[n+1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = (F[i-1] + F[i-2]) % 10;
        }
        return F[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

