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
        int[] F = new int[(int)to+1];
        int sum = 0;
        if (from == 1) { sum += 1; }
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= to; i++) {
            F[i] = F[i-1] + F[i-2];
            if (i >= from) { sum = (sum + F[i]) % 10; }
        }
        return (sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

