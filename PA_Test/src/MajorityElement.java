import java.util.*;
import java.io.*;
// Question 2
public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        //Edge Cases
        if(a.length == 0) {
            return -1;
        } else if (a.length == 1) {
            return 1;
        }

        Arrays.sort(a);
        if(a.length % 2 == 1){
            return ((a[0] == a[(a.length-1)/2]) ||
                    (a[(a.length-1)/2] == a[a.length-1]))
                    ? 1 : -1;
        } else {
            return ((a[0] == a[a.length/2]) ||
                    (a[a.length/2- 1] == a[a.length-1]))
                    ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

