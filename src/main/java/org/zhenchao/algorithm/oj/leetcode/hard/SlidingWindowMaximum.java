package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.239 Sliding Window Maximum
 *
 * @author zhenchao.wang 2017-05-10 17:50
 * @version 1.0.0
 */
public class SlidingWindowMaximum {

    /**
     * 双端队列法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        // 存放数组下标
        int[] result = new int[nums.length - k + 1];
        // 双端队列
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 新的值大于队列中的一部分值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // 删除队列中小于当前值的值
                deque.pollLast();
            }
            // 新值入队列
            deque.addLast(i);
            if (i - deque.peekFirst() >= k) {
                // 超出窗口值的元素出队列
                deque.pollFirst();
            }
            if (i >= k - 1) {
                // 开始记录
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // int[] nums = {7, 2, 4};
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(swm.maxSlidingWindow(nums, 5)));
    }

}
