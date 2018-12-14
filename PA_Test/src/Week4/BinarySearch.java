package Week4;

import java.io.*;
import java.util.*;
// Question 1
public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        return bs(a, 0, a.length-1, x);
    }

    static int bs(int[] a, int lo, int hi, int key) {
        if (hi < lo) { return -1; }
        int mid = (int)Math.floor(lo + (hi-lo)/2);
        if (key == a[mid]) {
            return mid;
        } else if (key < a[mid]) {
            return bs(a, lo, mid-1, key);
        } else {
            return bs(a, mid+1, hi, key);
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
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
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
