/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval == null) {
                list.add(interval);
            } else if (interval.start > newInterval.end) {
                list.add(newInterval);
                list.add(interval);
                newInterval = null;
            } else if (interval.end < newInterval.start) {
                list.add(interval);
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        if (newInterval != null) list.add(newInterval);
        return list;
    }
}
