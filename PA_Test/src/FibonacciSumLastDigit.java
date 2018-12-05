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

    private static long getFibonacciSum(long n) {
        if(n == 0 || n == 1){
            return n;
        }
        int[] F = new int[(int)n+3];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n+2; i++) {
            F[i] = (F[i-1] + F[i-2]) % 10;
        }
        return (F[(int)n+2] - 1)%10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumNaive(n);
        long g = getFibonacciSum(n);
        //System.out.println(s);
        System.out.println(g);
    }
}

