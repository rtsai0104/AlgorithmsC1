import java.util.Scanner;
// Question 3 Wk 6
public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        //write your code here
        String[] symbols = new String[exp.length()];
        for (int i = 0; i < exp.length(); i++) {
            symbols[i] = exp.substring(i, i+1);
        }
        int numDigits = (exp.length()+1)/2;
        long[][] minMatrix = new long[numDigits][numDigits];
        long[][] maxMatrix = new long[numDigits][numDigits];
        for (int i = 0; i < numDigits; i++) {
            minMatrix[i][i] = Long.parseLong(symbols[i*2]);
            maxMatrix[i][i] = Long.parseLong(symbols[i*2]);
        }

        /* Debug */
//        for (int i = 0; i < numDigits; i++) {
//            for (int j = 0; j < numDigits; j++) {
//                System.out.print(minMatrix[i][j] + "|");
//            }
//            System.out.print("\n");
//        }
//        for (int i = 0; i < numDigits; i++) {
//            for (int j = 0; j < numDigits; j++) {
//                System.out.print(maxMatrix[i][j] + "|");
//            }
//            System.out.print("\n");
//        }
        /* Debug */

        int j;
        long[] answers = new long[2];
        for (int s = 0; s < numDigits-1; s++) {
            for (int i = 0; i < numDigits-s-1; i++) {
                j = i + s + 1;
                answers = minAndMax(1, 2, minMatrix, maxMatrix);
                minMatrix[i][j] = 10;
                maxMatrix[i][j] = 10;
            }
        }

        return 0;
    }

    public static long[] minAndMax(int i, int j, long[][] minMatrix, long[][] maxMatrix) {
        long[] answer = new long[2];
        long a, b, c, d;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (int k = i; k < j; k++) {
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            min = Math.min(Math.min(min, a), Math.min(Math.min(b, c), d));
            max = Math.max(Math.max(max, a), Math.max(Math.max(b, c), d));
        }
        answer[0] = (long) min;
        answer[1] = (long) max;
        return answer;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

