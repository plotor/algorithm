package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * No.56 Merge Intervals
 *
 * @author zhenchao.wang 2017-05-26 16:59
 * @version 1.0.0
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }

        // 构造比较器，按照第一个元素进行排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });

        // 迭代处理
        Iterator<Interval> itr = intervals.iterator();
        Interval pre = itr.next();
        while (itr.hasNext()) {
            Interval curr = itr.next();
            if (pre.end >= curr.start) {
                pre.end = Math.max(pre.end, curr.end);
                itr.remove();
            } else {
                pre = curr;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> list = new ArrayList<Interval>();
        // list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(1, 3));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        List<Interval> result = mi.merge(list);
        System.out.println(result);
    }

}
