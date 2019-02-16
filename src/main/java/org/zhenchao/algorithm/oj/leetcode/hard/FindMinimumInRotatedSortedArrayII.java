package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 *
 * @author zhenchao.wang 2017-09-03 15:27
 * @version 1.0.0
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        return this.binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int start, int end) {
        if (end <= start) return nums[end];
        int mid = (start + end) / 2;
        if (nums[mid] > nums[end]) {
            return this.binarySearch(nums, mid + 1, end);
        } else if (nums[mid] < nums[end]) {
            return this.binarySearch(nums, start, mid);
        } else {
            // 此时不能保证 nums[start] 也等于 nums[mid], 所以需要再判断一次
            return nums[start] < nums[mid] ?
                nums[start] : Math.min(this.binarySearch(nums, start + 1, mid), this.binarySearch(nums, mid, end - 1));
        }
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII fm = new FindMinimumInRotatedSortedArrayII();
        int[] nums = {4, 5, 6, 7, -1, 0, 1, 2};
        // int[] nums = {3, 3, 1, 3};
        // int[] nums = {3, 1, 2, 3, 3, 3, 3};
        // int[] nums = {1, 3, 3};
        System.out.println(fm.findMin(nums));
    }

}
