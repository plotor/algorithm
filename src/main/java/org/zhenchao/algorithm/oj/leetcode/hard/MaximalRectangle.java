package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * No.85 Maximal Rectangle
 *
 * @author zhenchao.wang 2017-05-20 15:02
 * @version 1.0.0
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        Arrays.fill(height, 0);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            // 每新增一排都计算一下最大值
            max = Math.max(max, this.max(height));
        }
        return max;
    }

    /**
     * 向左向右寻找最大可扩展区域
     *
     * @param height
     * @return
     */
    private int max(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i - k - 1) * height[j]);
            }
            stack.push(i);
        }

        // 处理栈中剩余的元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (height.length - k - 1) * height[j]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] arr = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'},
        };
        System.out.println(mr.maximalRectangle(arr));
    }

}
