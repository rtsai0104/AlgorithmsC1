import java.util.*;
import java.io.*;
// Question 2
public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        //Edge Cases
        if(a.length == 1) {
            return 1;
        } else if (a.length == 2) {
            return a[0] == a[1] ? 1 : -1;
        }
        Arrays.sort(a);

        int m = a.length / 2;
        Boolean check1, check2;
        // if a has even number of elements
        if(a.length % 2 == 1){
            // 3/2 = 1; (Gets floored) 0 1 2
            // 9/2 = 4;                0 1 2 3 4 5 6 7 8
            check1 = a[0] == a[m];
            check2 = a[m] == a[a.length-1];
        }
        // if a has odd number of elements
        else {
            // 4/2 == 2 0 1 2 3
            // 10/2 == 5 |0| 1 2 3 ||4|| |5| 6 7 8 ||9||
            check1 = a[0] == a[m];
            check2 = a[m-1] == a[a.length-1];
        }
        return check1 || check2 ? 1 : -1;
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

