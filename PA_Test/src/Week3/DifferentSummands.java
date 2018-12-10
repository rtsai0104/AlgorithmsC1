package Week3;

import java.util.*;
// Question 5
public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum = 0;
        int i = 0;
        //int j = 1;
        while(sum != n) {
            i++;
            sum += i;
            if(sum > n) {
                sum -= (i-1);
                summands.set(summands.size()-1, summands.get(summands.size()-1)+1);
                //System.out.println("Loop" + j + ": i = " + i + " , sum = " + sum);
                if (sum == n) {
                    return summands;
                }
            } else if (sum <= n) {
                summands.add(i);
                //System.out.println("Loop" + j + ": i = " + i + " , sum = " + sum);
            }

            //j++;
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}