package oj.newcoder;

import oj.dto.Interval;

import java.util.ArrayList;

public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval == null)
            return intervals;
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        int i = 0;
        boolean insert = false;
        for (; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i));
            } else if (intervals.get(i).start > newInterval.end) {
                res.add(newInterval);
                res.add(intervals.get(i));
                i++;
                insert = true;
                break;
            } else if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.end) {
                res.add(intervals.get(i));
                i++;
                insert = true;
                break;
            } else if (intervals.get(i).start >= newInterval.start && intervals.get(i).end <= newInterval.end) {
                continue;
            } else if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start) {
                newInterval.start = intervals.get(i).start;
            } else if (newInterval.start <= intervals.get(i).start && newInterval.end >= intervals.get(i).start) {
                newInterval.end = intervals.get(i).end;
            }
        }
        for (; i < intervals.size(); i++)
            res.add(intervals.get(i));
        if (!insert)
            res.add(newInterval);
        return res;
    }
}
