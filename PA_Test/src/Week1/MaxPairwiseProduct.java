package Week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        int i1 = 0;
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] > numbers[i1]) {
                i1 = i;
            }
        }
        int i2 = 0;
        if (i1 == 0) {
            i2 = 1;
        }

        for (int i = 1; i < numbers.length; i++) {
            if (i != i1 && numbers[i] > numbers[i2]) {
                i2 = i;
            }
        }

        return (long)numbers[i1] * numbers[i2];
    }



    static long getMaxPairwiseProductNaive(int[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product, (long)numbers[i] * numbers[j]);
            }
        }
        return product;

    }

     static void stressTest(int N, int M) {
        while(true) {
            int n = (int) (Math.random() * N) + 2;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (int)(Math.random() * (M+1));
            }
            for (int j = 0; j < n; j++) {
                System.out.print(String.valueOf(arr[j]) + " ");
            }
            long res = getMaxPairwiseProduct(arr);
            long resnaive = getMaxPairwiseProductNaive(arr);
            if (res == resnaive) {
                System.out.print("\nOkay\n");
            } else {
                System.out.print("Wrong Answer: " + String.valueOf(resnaive) + " " + String.valueOf(res) + "\n");
                return;
            }
        }
    }

    static int[] makeArray() {
        int[] arr = new int[10];
        arr[0] = 68165;
        arr[1] = 87637;
        arr[2] = 74297;
        arr[3] =  2904;
        arr[4] = 32873;
        arr[5] = 86010;
        arr[6] = 87637;
        arr[7] = 66131;
        arr[8] = 82858;
        arr[9] = 82935;
        return arr;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        //stressTest(10, 100000);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}