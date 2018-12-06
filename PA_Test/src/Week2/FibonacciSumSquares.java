package Week2;

import java.math.BigInteger;
import java.util.*;
// Question 8
public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static BigInteger getFibonacciSumSquares(long n) {
        if(n == 0 || n == 1 || n%60 == 0 || n%60 == 1){
            return BigInteger.valueOf(n%10);
        }
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
        BigInteger z;
        for (int i = 2; i <= (n)%60; i++) {
            z = x.add(y);
            x = y;
            y = z;
        }
        return y.multiply(x.add(y)).mod(BigInteger.TEN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSumSquares(n));
    }
}

