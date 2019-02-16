package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.31 Next Permutation
 *
 * @author zhenchao.wang 2017-05-04 21:39
 * @version 1.0.0
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            // 说明已经是最大了，逆置数组
            this.reverse(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            return;
        }
        // 从i位置开始往后找比num[i]大的最小值
        int j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] <= nums[i - 1]) {
                break;
            }
        }
        // 对调(i-1)和j处的值
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = tmp;
        // 将i之后的值逆置
        this.reverse(nums, i, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 逆置数组的指定区间
     *
     * @param nums
     * @param left
     * @param right
     */
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {8, 7, 6, 5, 4, 2};
        np.nextPermutation(nums);
    }

}
