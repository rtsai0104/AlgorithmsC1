import java.util.*;
// Question 6
public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }

    public static Boolean isGreaterOrEqual(String digit, String maxDigit) {
        Boolean lenLessThan = digit.length() < maxDigit.length();

        return false;
    }
}

