package Week5;

import java.util.*;
// Question 2 Wk 5
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] calculator = new int[n+1];
        calculator[0] = 0;
        calculator[1] = 0;
        int addition, div2, div3;
        for (int i = 2; i <= n; i++) {
            addition = calculator[i-1] + 1;
            if (i % 2 == 0) {
                div2 = calculator[i / 2] + 1;
            } else {
                div2 = 1000000000;
            }
            if (i % 3 == 0) {
                div3 = calculator[i / 3] + 1;
            } else {
                div3 = 1000000000;
            }
            calculator[i] = Math.min(addition, Math.min(div2, div3));
        }
        int x = n;
        while(x > 0) {
            sequence.add(x);
            if(x % 3 == 0 && calculator[x/3] == calculator[x]-1) {
                    x = x/3;
            } else if (x % 2 == 0 && calculator[x/2] == calculator[x]-1) {
                    x = x/2;
            } else {
                x--;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

