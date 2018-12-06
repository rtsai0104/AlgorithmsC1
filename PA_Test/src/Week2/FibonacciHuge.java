package Week2;

import java.util.*;
// Question 5
public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static java.math.BigInteger getFibonacciHuge(long n, long m) {
        return calc_fib1(n % pisano(m)).mod(java.math.BigInteger.valueOf(m));
    }

    private static java.math.BigInteger calc_fib1(long n) {
        if(n == 0 || n == 1){
            return java.math.BigInteger.valueOf(n);
        }
        java.math.BigInteger[] F = new java.math.BigInteger[(int)n+1];
        F[0] = java.math.BigInteger.valueOf(0);
        F[1] = java.math.BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1].add(F[i-2]);
        }
        return F[(int)n];
    }

    private static long pisano(long m) {
        if(m == 1)
            return 1;

        long first = 0;
        long second = 1;
        long x;
        for (int i = 1; i < Math.pow(m, 2)+1; i++) {
            x = (first + second) % m;
            first = second;
            second = x;
            if(first == 0 && second == 1)
                return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

