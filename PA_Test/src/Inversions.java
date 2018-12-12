import java.util.*;
// Question 4
public class Inversions {

    private long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        Tuple input = new Tuple(a, 0);
        Tuple out = mergeSort(input);
        return numberOfInversions;
    }

    public int[] MergeSort(int[] A) {
        if (A.length == 1) {
            return A;
        }
        int m = (int) Math.floor(A.length/2);
        int[] B = MergeSort(Arrays.copyOfRange(A, 0, m));
        int[] C = MergeSort(Arrays.copyOfRange(A, m+1, A.length-1));

        return Merge(B, C);
    }

    public int[] Merge(int[] B, int[] C) {
        int[] D = new int[B.length+C.length];
        while(!B.isEmpty && !C.isEmpty){
            int b = B[0];
            int c = C[0];
            if(b <= c){
                D.add(b);
            } else {
                D.add(c);
            }
        }
        if(!B.isEmpty) { D.add(B[0]); }
        else { D.add(C[0]); }
        return D;
    }

    class Tuple {
        ArrayList<Integer> a;
        int numInv;

        Tuple(ArrayList<Integer> a, int numInv) {
            this.a = a;
            this.numInv = numInv;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

