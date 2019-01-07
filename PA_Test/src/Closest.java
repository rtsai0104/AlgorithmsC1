import java.io.*;
import java.util.*;

import static java.lang.Math.*;

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
        Point[] points = new Point[x.length];
        double middleLine = 0;
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
            middleLine += x[i];
        }
        middleLine /= x.length;
        double ans = calculateDistance(points, 0, points.length-1);
        return middleLine;
    }

    static double calculateDistance(Point[] points, int left, int right) {
        if(right-left == 1) {
            return distance(points[left], points[right]);
        } else if (right-left == 2) {
            double d1 = distance(points[left], points[left+1]);
            double d2 = distance(points[left], points[right]);
            double d3 = distance(points[left+1], points[right]);
            return Math.min(d1, Math.min(d2, d3));
        } else {
            int m = (int)Math.ceil(points.length/2.0);
            return Math.min(calculateDistance(points, left, m-1),
                            calculateDistance(points, m, right));
        }
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2));
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
