import java.util.*;
// Question 4
public class Inversions {

    private long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        ArrayList<Integer> a_copy = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            a_copy.add(a[i]);
        }
        Tuple input = new Tuple(a_copy, 0);
        Tuple out = MergeSort(input);
        return out.numInv;
    }

    public Tuple MergeSort(Tuple A) {
        if (A.mList.size() == 1) {
            return A;
        }
        int m = (int) Math.floor(A.mList.size()/2);
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for(int i = 0; i < A.mList.size(); i++) {
            if(i <= m) {
                x.add(A.mList.get(i));
            } else {
                y.add(A.mList.get(i));
            }
        }
        Tuple B = MergeSort(new Tuple(x, A.numInv));
        Tuple C = MergeSort(new Tuple(y, A.numInv));

        return Merge(B, C);
    }

    public Tuple Merge(Tuple B, Tuple C) {
        ArrayList<Integer> D = new ArrayList<>();
        long x = B.numInv + C.numInv;
        while(!B.mList.isEmpty() && !C.mList.isEmpty()){
            int b = B.mList.get(0);
            int c = C.mList.get(0);
            if(b <= c){
                D.add(b);
                B.mList.remove(b);
            } else {
                D.add(c);
                C.mList.remove(c);
                x += B.mList.size();
            }
        }
        if (!B.mList.isEmpty()) { D.add(B.mList.get(0)); }
        else { D.add(C.mList.get(0)); }
        return new Tuple(D, x);
    }

    class Tuple {
        ArrayList<Integer> mList;
        long numInv;

        Tuple(ArrayList<Integer> a, long numInv) {
            this.mList = a;
            this.numInv = numInv;
        }

        public void setter(ArrayList<Integer> a, long num) {
            this.mList = a;
            this.numInv = num;
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
        Inversions inversion = new Inversions();
        System.out.println(inversion.getNumberOfInversions(a, b, 0, a.length));
    }
}