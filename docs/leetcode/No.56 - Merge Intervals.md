### Merge Intervals

> No.56, medium

Given a collection of intervals, merge all overlapping intervals.

For example,

Given `[1,3],[2,6],[8,10],[15,18]`,

return `[1,6],[8,10],[15,18]`.

#### 分析

题目比较简单，对原数组按照 start 值进行非递减排序，然后遍历合并即可。

#### 实现

```java
class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0; end = 0;
    }

    public Interval(int start, int end) {
        this.start = start; this.end = end;
    }
}

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
```