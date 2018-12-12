import java.io.*;
import java.util.*;

import static java.lang.Math.*;
// Question 6
public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        Point[] points = new Point[x.length];
        for(int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        Arrays.sort(points);
        ans = Math.min(recurse(points, 0, (int) Math.ceil(points.length/2)-1),
                recurse(points, (int) Math.ceil(points.length/2), points.length-1));
        return ans;
    }

    static double recurse(Point[] points, int lo, int hi) {
        if(points.length == 2) {
            return distance(points[lo], points[hi]);
        } else if (points.length == 3) {
            return Math.min(Math.min(distance(points[lo], points[lo+1]),
                    distance(points[lo], points[hi])), distance(points[lo+1], points[hi]));
        }
        return Math.min(recurse(points, lo, (int) Math.ceil(lo + (hi-lo)/2)),
                recurse(points, (int) Math.ceil(lo + (hi-lo)/2) + 1, hi));
    }

    static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
