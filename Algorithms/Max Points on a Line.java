/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        int max = 1;
        for (Point point : points) {
            HashMap<Double, Integer> hash = new HashMap<Double, Integer>();
            int same = 0;
            for (Point other : points) {
                if (point.x == other.x && point.y == other.y) {
                    same++;
                    continue;
                }
                double slope = point.x == other.x ? Double.MAX_VALUE : (double)(point.y - other.y) / (point.x - other.x) ;
                if (hash.containsKey(slope)) hash.put(slope, hash.get(slope) + 1);
                else hash.put(slope, 1);
            }
            for (Double slope : hash.keySet()) {
                max = Math.max(max, hash.get(slope) + same);
            }
            max = Math.max(max, same);
        }
        return max;
    }
}
