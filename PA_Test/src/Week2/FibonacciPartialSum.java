package Week2;

import java.math.BigInteger;
import java.util.*;
// Question 7
public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSum(long from, long to) {
        return (getFibSum(to).subtract(getFibSum(from-1))).mod(BigInteger.TEN).longValue();
    }

    private static BigInteger getFibSum(long n) {
        if(n == 0 || n == 1){
            return BigInteger.valueOf(n);
        }
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
        BigInteger z;
        for (int i = 2; i <= (n+2) % 60; i++) {
            z = x.add(y);
            x = y;
            y = z;
//            System.out.print(i);
//            System.out.print(" : ");
//            System.out.print(y);
//            System.out.print(" ");
//            System.out.print(x);
//            System.out.print(" ");
//            System.out.println(z);
        }

        return (y.subtract(BigInteger.ONE));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

