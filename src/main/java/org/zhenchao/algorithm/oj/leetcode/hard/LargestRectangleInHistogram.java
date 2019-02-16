package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 *
 * @author zhenchao.wang 2017-12-10 10:09
 * @version 1.0.0
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        if (null == heights || 0 == heights.length) {
            return max;
        }

        // 栈中始终存放比当前栈顶元素值大的元素的索引
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                // 针对比栈顶元素大的元素，直接入栈
                stack.push(i++);
            } else {
                int p = stack.pop();
                int h = heights[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = heights[p];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, h * w);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(lrh.largestRectangleArea(heights));
    }

}
