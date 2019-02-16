package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * No.41 First Missing Positive
 *
 * @author zhenchao.wang 2017-05-15 16:39
 * @version 1.0.0
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int len = nums.length;
        for (int i = 0; i < len; ) {
            if (nums[i] <= 0 || nums[i] >= len || nums[i] == (i + 1)) {
                // 如果是非正数，或者位于正确位置的数，或者大于数组长度的数，直接continue
                i++;
                continue;
            }
            // 交换 nums[tmp-1] 和 nums[i]
            int tmp = nums[i];
            if (nums[tmp - 1] == nums[i]) {
                // 如果 nums[tmp-1] == nums[i]，则跳过，否则陷入死循环
                i++;
                continue;
            }
            nums[i] = nums[tmp - 1];
            nums[tmp - 1] = tmp;
        }
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        // int[] nums = {3, 4, -1, 1};
        // int[] nums = {0};
        // int[] nums = {-1, 4, 2, 1, 9, 10};
        int[] nums = {2, 1};
        System.out.println(fmp.firstMissingPositive(nums));
    }

}
