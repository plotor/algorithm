package org.zhenchao.algorithm.oj;

/**
 * @author zhenchao.wang 2017-05-26 17:00
 * @version 1.0.0
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
