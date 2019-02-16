package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * 42. Trapping Rain Water
 *
 * @author zhenchao.wang 2017-08-13 11:38
 * @version 1.0.0
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (null == height || height.length == 0) return 0;

        // 计算各个位置左挡板的最大高度
        int[] left = new int[height.length];
        int max = left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(max, height[i]);
            max = left[i];
        }

        // 计算各个位置右挡板的最大高度
        int[] right = new int[height.length];
        max = right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(max, height[i]);
            max = right[i];
        }

        // 遍历计算各个位置能够蕴含的最大水量，去除首尾，因为首尾不可能装水
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            total += Math.min(left[i], right[i]) - height[i];  // 左右挡板能够蕴含的最大水量 - 不能装水的面积
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        // int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {2, 0, 2};
        System.out.println(trw.trap(height));
    }

}
