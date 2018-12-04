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

    private static long getFibonacciHuge(long n, long m) {
        if(n == 0 || n == 1){
            return n;
        }
        long x = 0;
        if (m == 2) {
            x = 3;
        } else {
            x = 2*(m+1);
        }

        return calc_fib(n % x) % m;
    }

    private static long calc_fib(long n) {
        if(n == 0 || n == 1){
            return n;
        }
        long[] F = new long[(int)n+1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        return F[(int)n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

