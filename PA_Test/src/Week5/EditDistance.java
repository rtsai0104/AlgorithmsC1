package Week5;

import java.util.*;
// Question 3 Wk 5
class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here
        char[] A = new char[s.length()+1];
        char[] B = new char[t.length()+1];
        int[][] D = new int[s.length()+1][t.length()+1];

        for (int i = 1; i <= s.length(); i++) {
            A[i] = s.charAt(i-1);
        }
        for (int i = 1; i <= t.length(); i++) {
            B[i] = t.charAt(i-1);
        }
        for (int i = 0; i <= s.length(); i++) {
            D[i][0] = i;
        }
        for (int j = 0; j <= t.length(); j++) {
            D[0][j] = j;
        }

        int insertion, deletion, match, mismatch;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                insertion = D[i][j-1] + 1;
                deletion = D[i-1][j] + 1;
                match = D[i-1][j-1];
                mismatch = D[i-1][j-1] + 1;
                if (A[i] == B[j]) {
                    D[i][j] = Math.min(insertion, Math.min(deletion, match));
                } else {
                    D[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
                }
            }
        }
        return D[s.length()][t.length()];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
