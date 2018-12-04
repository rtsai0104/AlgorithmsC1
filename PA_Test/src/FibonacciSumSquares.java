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

    private static long getFibonacciSumSquares(long n) {
        return (calc_fib(n+1) * calc_fib(n)) % 10;
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
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}

