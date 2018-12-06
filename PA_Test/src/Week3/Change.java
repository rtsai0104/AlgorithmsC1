package Week3;

import java.util.Scanner;
// Question 1
public class Change {
    private static int getChange(int m) {
        int count = 0;
        count += Math.floor(m/10);
        m = m%10;
        return count + (m >= 5 ? m - 4: m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}