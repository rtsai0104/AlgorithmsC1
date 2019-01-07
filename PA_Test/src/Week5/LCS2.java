package Week5;

import java.util.*;
// Question 4
public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int[][] grid = new int[a.length+1][b.length+1];
        for (int i = 0; i <= a.length; i++) {
            grid[i][0] = 0;
        }
        for (int j = 0; j <= b.length; j++) {
            grid[0][j] = 0;
        }
        int max = 0;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if(a[i-1] == b[j-1]) {
                    grid[i][j] = grid[i-1][j-1]+1;
                } else {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]);
                }
                if(max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
        }
//        for (int i = 0; i <= a.length; i++) {
////            for (int j = 0; j <= b.length; j++) {
////                System.out.print(grid[i][j] + "|");
////            }
////            System.out.print("\n");
////        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

