package Week3;

import java.util.*;
// Question 6
public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        ArrayList<String> ac = new ArrayList<>(Arrays.asList(a));
        while (!ac.isEmpty()) {
            String maxDigit = "0";
            for (int j = 0; j < ac.size(); j++) {
                if (isGreaterOrEqual(ac.get(j), maxDigit)) {
                    maxDigit = ac.get(j);
                }
            }
            result += String.valueOf(maxDigit);
            ac.remove(String.valueOf(maxDigit));
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
        return Integer.valueOf(digit.concat(maxDigit)) >= Integer.valueOf(maxDigit.concat(digit));
    }
}

