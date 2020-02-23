package oj.newcoder.todo;


import oj.dto.Point;

import java.util.*;

// TODO: 2020/2/22  
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;
        if (points.length <= 2)
            return 1;
        List<Set<Point>> lines = new ArrayList<>();
        Set<Point> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (set.contains(points[j]))
                    continue;
                boolean con = false;
                for (int k = 0; k < lines.size(); k++) {
                    con = judge(lines.get(k), points[j]);
                    if (con) {
                        lines.get(k).add(points[j]);
                        res = res > lines.get(k).size() ? res : lines.get(k).size();
                        break;
                    }
                }
                if (!con) {
                    Set<Point> newSet = new HashSet<>();
                    newSet.add(points[i]);
                    newSet.add(points[j]);
                    res = res > 2 ? res : 2;
                    lines.add(newSet);
                }
            }
            set = lines.get(0);
            lines = new ArrayList<>();
        }
        return res;
    }

    boolean judge(Set<Point> set, Point point) {
        Iterator<Point> iterator = set.iterator();
        Point one = iterator.next();
        Point two = iterator.next();
        int x1 = one.x - two.x;
        int y1 = one.y - two.y;
        int x2 = one.x - point.x;
        int y2 = one.y - point.y;
        if (x1 * y2 == x2 * y1)
            return true;
        return false;
    }

}
