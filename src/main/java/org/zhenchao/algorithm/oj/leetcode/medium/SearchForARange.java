package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.34 Search for a Range
 *
 * @author zhenchao.wang 2017-05-08 22:52
 * @version 1.0.0
 */
public class SearchForARange {

    /**
     * 分别二分查找左右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int index = this.search(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return result;
        }

        // 查找左边界
        int left = index;
        while (left > 0 && nums[left] == nums[left - 1]) {
            // 进入进来表明左边一位必定等于目标值，所以left - 1，降低检索时间（同时避免死循环）
            left = this.search(nums, 0, left - 1, target);
        }
        result[0] = left;

        // 查找右边界
        int right = index;
        while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
            // 进入进来表明右边一位必定等于目标值，所以right + 1，降低检索时间（同时避免死循环）
            right = this.search(nums, right + 1, nums.length - 1, target);
        }
        result[1] = right;
        return result;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int search(int[] nums, int start, int end, int target) {
        if (end < start) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return this.search(nums, start, mid - 1, target);
        } else {
            return this.search(nums, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        SearchForARange sfr = new SearchForARange();
        // int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(sfr.searchRange(nums, 2)));
    }

}
