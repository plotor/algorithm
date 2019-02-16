package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * @author zhenchao.wang 2017-08-13 10:10
 * @version 1.0.0
 */
public class LongestConsecutiveSequence {

    /**
     * 基于 HashSet
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (final int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (final int num : nums) {
            max = Math.max(max, this.downTraversal(num, set) + this.upTraversal(num, set));
        }
        return max;
    }

    /**
     * 向下遍历
     *
     * @param num
     * @param set
     * @return
     */
    private int downTraversal(int num, Set<Integer> set) {
        int len = 0;
        for (int i = num; ; i--) {
            if (set.contains(i)) {
                len++;
                set.remove(i);
            } else {
                return len;
            }
        }
    }

    /**
     * 向上遍历
     *
     * @param num
     * @param set
     * @return
     */
    private int upTraversal(int num, Set<Integer> set) {
        int len = 0;
        for (int i = num + 1; ; i++) {
            if (set.contains(i)) {
                len++;
                set.remove(i);
            } else {
                return len;
            }
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {-1, 1, 0};
        System.out.println(lcs.longestConsecutive(nums));
    }

}
