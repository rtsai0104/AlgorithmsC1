package Week2;

import java.util.*;
// Question 4
public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcm(int a, int b) {
        if (a == 0 && b == 0){ return 0; }
        return (Math.abs((long)a*b)/gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) { return a; }
        return gcd(b, a%b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
