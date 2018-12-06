import java.util.Arrays;
import java.util.Scanner;
// Question 2
public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        if (capacity == 0) {
            return 0;
        }
        double[] unitVal = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            unitVal[i] = (double)values[i]/weights[i];
            //System.out.println(unitVal[i]);
//            System.out.print("Value ");
//            System.out.println(values[i]);
//            System.out.print("Weight ");
//            System.out.println(unitVal[i]);
        }
        Arrays.sort(unitVal);
        for (int i = values.length-1; i >= 0; i--) {
            if (capacity == 0){
                return value;
            }
            System.out.println(unitVal[i]);
            double a = Math.min(unitVal[i], capacity);
            value += a*unitVal[i];
            capacity -= a;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
