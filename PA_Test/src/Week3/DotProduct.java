import java.math.BigInteger;
import java.util.*;
// Question 3
public class DotProduct {
    private static BigInteger maxDotProduct(BigInteger[] a, BigInteger[] b) {
        //write your code here
        BigInteger result = BigInteger.ZERO;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            result = result.add((a[i].multiply(b[i])));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] a = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = BigInteger.valueOf(scanner.nextInt());
        }
        BigInteger[] b = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            b[i] = BigInteger.valueOf(scanner.nextInt());
        }
        System.out.println(maxDotProduct(a, b));
    }
}

