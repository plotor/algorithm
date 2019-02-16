package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.11 Container With Most Water
 *
 * @author zhenchao.wang 2015-9-26 17:36:09
 * @version 1.0.0
 */
public class ContainerWithMostWater {

    /**
     * 用两个指针从两边向中间移动，每次比较当前两个指针对应的值，小的一端往前进一格，同时计算当前的面积，保存最大值
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;  // 左指针
        int right = height.length - 1;  // 右指针

        int max = Integer.MIN_VALUE;
        while (left < right) {
            // 计算面积
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                // 缓存最大面积
                max = area;
            }
            // 哪边高度小，哪边移动
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return max;
    }

}
