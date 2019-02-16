package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.81 Search in Rotated Sorted Array II
 *
 * @author zhenchao.wang 2017-06-18 15:21
 * @version 1.0.0
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        return this.binarySearch(nums, 0, nums.length - 1, target) >= 0;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int middle = (left + right) / 2;
        if (target == nums[middle]) return 1;
        if (nums[left] < nums[middle]) { // 说明左边是有序的
            if (target >= nums[left] && target < nums[middle]) {
                return Arrays.binarySearch(nums, left, middle, target);
            } else {
                return this.binarySearch(nums, middle + 1, right, target);
            }
        } else if (nums[middle] < nums[right]) { // 说明右边是有序的
            if (target > nums[middle] && target <= nums[right]) {
                return Arrays.binarySearch(nums, middle + 1, right + 1, target);
            } else {
                return this.binarySearch(nums, left, middle - 1, target);
            }
        } else {
            // 相等时不一定有序，比如 {1, 3, 1, 1, 1} middle = 2 时就不好判断
            if (this.binarySearch(nums, left, middle - 1, target) < 0) {
                return this.binarySearch(nums, middle + 1, right, target);
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII sra = new SearchInRotatedSortedArrayII();
        int[] nums = {1, 3, 1, 1, 1};
        System.out.println(sra.search(nums, 3));
    }

}
