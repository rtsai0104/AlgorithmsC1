import java.util.*;
import java.io.*;
// Question 2 Wk 6
public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        int sum = java.util.stream.IntStream.of(A).sum();
        if (A.length <= 2 || sum % 3 != 0) {
            return 0;
        }
        int divAmt = sum/3;

        return divAmt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

