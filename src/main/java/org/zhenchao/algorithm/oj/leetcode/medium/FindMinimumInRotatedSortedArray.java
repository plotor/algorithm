package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * @author zhenchao.wang 2017-09-03 15:08
 * @version 1.0.0
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return this.bSearch(nums, 0, nums.length - 1);
    }

    private int bSearch(int[] nums, int start, int end) {
        if (end <= start) {
            return nums[end];
        }
        int mid = (start + end) / 2;
        if (nums[mid] > nums[end]) {
            return this.bSearch(nums, mid + 1, end);
        } else {
            return this.bSearch(nums, start, mid);
        }
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fm = new FindMinimumInRotatedSortedArray();
        int[] nums = {4, 4};
        System.out.println(fm.findMin(nums));
    }

}
