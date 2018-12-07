package Week3;

import java.util.Arrays;
import java.util.Scanner;
// Question 2
public class FractionalKnapsack {
    private double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        if (capacity == 0) {
            return 0;
        }
        int cap = capacity;
        KnapsackObject[] unitVal = new KnapsackObject[values.length];
        for (int i = 0; i < values.length; i++) {
            unitVal[i] = new KnapsackObject(weights[i], values[i]);
        }
        Arrays.sort(unitVal);
        for (int i = values.length-1; i >= 0; i--) {
            if (cap == 0) { return value; }
            int a = Math.min(unitVal[i].weight, cap);
            value += a*unitVal[i].unitVal;
            cap -= a;
            //System.out.println((i+1) + " unitVal:" + unitVal[i].unitVal + " a:" + a + " cap:" + cap);
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
        FractionalKnapsack fs = new FractionalKnapsack();
        System.out.println(fs.getOptimalValue(capacity, values, weights));
    }

    class KnapsackObject implements Comparable<KnapsackObject> {
        public int weight;
        public int value;
        public double unitVal;

        KnapsackObject(int weight, int value){
            this.weight = weight;
            this.value = value;
            this.unitVal = (double) value / weight;
        }

        public int compareTo(KnapsackObject nextObj) {
            if (this.unitVal < nextObj.unitVal) { return -1; }
            else if (this.unitVal > nextObj.unitVal) { return 1; }
            return 0;
        }
    }
}
