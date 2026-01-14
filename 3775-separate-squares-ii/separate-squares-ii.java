import java.util.*;

class Solution {

    static class Event {
        double y;
        int type; // +1 enter, -1 exit
        int x1, x2;

        Event(double y, int type, int x1, int x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    int[] xs;
    int[] coverCount;
    double[] coverLen;

    // Segment Tree Update
    void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql >= r || qr <= l) return;
        if (ql <= l && r <= qr) {
            coverCount[node] += val;
        } else {
            int mid = (l + r) / 2;
            update(node * 2, l, mid, ql, qr, val);
            update(node * 2 + 1, mid, r, ql, qr, val);
        }

        if (coverCount[node] > 0) {
            coverLen[node] = xs[r] - xs[l];
        } else {
            if (l + 1 == r) coverLen[node] = 0;
            else coverLen[node] = coverLen[node * 2] + coverLen[node * 2 + 1];
        }
    }

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();
        Set<Integer> xSet = new HashSet<>();

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
            xSet.add(x);
            xSet.add(x + l);
        }

        xs = xSet.stream().sorted().mapToInt(i -> i).toArray();
        int n = xs.length;

        coverCount = new int[4 * n];
        coverLen = new double[4 * n];

        events.sort(Comparator.comparingDouble(e -> e.y));

        List<double[]> strips = new ArrayList<>();
        double totalArea = 0;
        double prevY = events.get(0).y;

        int i = 0;
        while (i < events.size()) {
            double curY = events.get(i).y;
            double height = curY - prevY;

            if (height > 0) {
                double width = coverLen[1];
                double area = width * height;
                strips.add(new double[]{prevY, curY, width});
                totalArea += area;
            }

            while (i < events.size() && events.get(i).y == curY) {
                Event e = events.get(i);
                int l = Arrays.binarySearch(xs, e.x1);
                int r = Arrays.binarySearch(xs, e.x2);
                update(1, 0, n - 1, l, r, e.type);
                i++;
            }
            prevY = curY;
        }

        // Find Y where area = totalArea / 2
        double half = totalArea / 2;
        double acc = 0;

        for (double[] s : strips) {
            double area = (s[1] - s[0]) * s[2];
            if (acc + area >= half) {
                return s[0] + (half - acc) / s[2];
            }
            acc += area;
        }
        return 0;
    }
}
