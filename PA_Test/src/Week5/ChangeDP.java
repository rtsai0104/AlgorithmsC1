package Week5;

import java.util.Scanner;
// Question 1 Wk 5
public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int[] coins = new int[3];
        coins[0] = 1;
        coins[1] = 3;
        coins[2] = 4;
        int[] minNumCoins = new int[m+1];
        minNumCoins[0] = 0;
        int numCoins;

        for(int i = 1; i <= m; i++){
            minNumCoins[i] = 1000000000;
            for(int j = 0; j < 3; j++) {
                if (i >= coins[j]) {
                    numCoins = minNumCoins[i-coins[j]] + 1;
                    if (numCoins < minNumCoins[i]) {
                        minNumCoins[i] = numCoins;
                    }
                }
            }
        }
        return minNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

