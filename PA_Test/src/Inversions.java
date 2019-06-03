import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        //write your code here
        numberOfInversions += mergeInversions(a, b, left, right, ave+1);
        return numberOfInversions;
    }

    static long mergeInversions(int[] a, int[] b, int left, int right, int mid) {
        long numberOfInversions = 0;
        int x = left, y = mid, z = left;
        while ((x <= mid-1) && (y <= right)) {
            if (a[x] <= a[y]) {
                b[z++] = a[x++];
//                x++;
//                z++;
            } else {
                b[z++] = a[y++];
//                y++;
//                z++;

                numberOfInversions += (mid-x);
            }

            while (x <= mid-1) {
                b[z++] = a[x++];
//                x++;
//                z++;
            }
            while (y <= right) {
                b[z++] = a[y++];
//                y++;
//                z++;
            }

            for (x = left; x <= right; x++) {
                a[x] = b[x];
            }
        }
        return numberOfInversions;
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

