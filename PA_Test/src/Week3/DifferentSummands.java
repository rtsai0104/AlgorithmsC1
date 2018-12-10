package Week3;

import java.util.*;
// Question 5
public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum = 0;
        int i = 0;
        //int j = 1;
//        int j = summands.size();
        while(sum != n) {
            i++;
            sum += i;
            if(sum > n) {
                sum -= (i-1);
                summands.set(summands.size()-1, summands.get(summands.size()-1)+1);
                if (sum == n) {
                    return summands;
                }
            } else if (sum <= n) {
                summands.add(i);
            }
//            System.out.println("Loop" + j + ": i = " + i + " , sum = " + sum);
//            j++;
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

/* j = size of summands array
  8
  i = 1,         1              = 1 sum < n, continue to next number j = 1
  i = 2,         1 2            = 3 sum < n, continue to next number j = 2
  i = 3,         1 2 3          = 6 sum < n, continue to next number j = 3
  i = 4,         1 2 3 4        =10 sum > n, iterate i-1th number
  i = 4,         1 2 4          = 7 sum < n, continue to next number j = 3
          1 2 4 5        =12 sum > n, iterate ith number
          1 2 5          = 8
 */

/* j = size of summands array
    4
   i = 1,  1      = 1 sum < n, continue to next number  j = 1
   i = 2,  1 2    = 3 sum < n, continue to next number  j = 2
   i = 3,  1 2 3  = 6 sum > n, iterate i-1th number
   i = 3,  1 3    = 4 done.
 */

/* Steps:

    Loop1 : i = 1, sum = 1, sum <= 8 -> summands = [1]
    Loop2 : i = 2, sum = 3, sum <= 8 -> summands = [1 2]
    Loop3 : i = 3, sum = 6, sum <= 8 -> summands = [1 2 3]
    Loop4 : i = 4, sum = 10, sum > 8 -> sum = 7, summands = [1 2 4]
    Loop5 : i = 5, sum = 12, sum > 8 -> sum = 8, summands = [1 2 5]

 */

