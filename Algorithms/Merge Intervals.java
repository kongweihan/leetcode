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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> list = new ArrayList<Interval>();
        Interval newInterval = null;
        for (Interval interval : intervals) {
            if (newInterval == null) {
                newInterval = interval;
            } else if (newInterval.end < interval.start) {
                list.add(newInterval);
                newInterval = interval;
            } else if (newInterval.start > interval.end) {
                list.add(interval);
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        if (newInterval != null) list.add(newInterval);
        return list;
    }
    
    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
