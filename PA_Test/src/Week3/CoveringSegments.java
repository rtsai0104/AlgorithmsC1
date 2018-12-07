package Week3;

import java.util.*;
// Question 4
public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        //write your code here
        List<Integer> points = new ArrayList<>();
        Arrays.sort(segments);
        int currentpoint = segments[0].end;
        for (int i = 1; i < segments.length; i++) {
            //System.out.println(segments[i].start + " : " + segments[i].end);
            if(currentpoint < segments[i].start) {
                points.add(currentpoint);
                currentpoint = segments[i].end;
            }
        }
        points.add(currentpoint);
        return points;
    }

    private static class Segment implements Comparable <Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Segment nextObj) {
            if (this.end < nextObj.end) { return -1; }
            else if (this.end > nextObj.end) { return 1; }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

