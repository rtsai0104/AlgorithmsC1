import java.math.BigInteger;
import java.util.*;
// Question 6
public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static int getFibonacciSum(long n) {
        if(n == 0 || n == 1){
            return (int)n;
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

        return (y.subtract(BigInteger.ONE)).mod(BigInteger.TEN).intValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSum(n));
    }
}

