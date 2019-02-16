package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * No.33 Search in Rotated Sorted Array
 *
 * @author zhenchao.wang 2017-05-07 18:07
 * @version 1.0.0
 */
public class SearchInRotatedSortedArray {

    /**
     * (left, middle, right) 分别表示左、中、右
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int result = this.search(nums, 0, nums.length - 1, target);
        // 统一处理Arrays.binarySearch在查找不到时的返回结果
        return result < 0 ? -1 : result;
    }

    public int search(int[] nums, int left, int right, int target) {
        if (left == right) {
            return target == nums[left] ? left : -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[left] <= nums[middle]) {
            // 说明left到middle是有序的
            if (nums[left] <= target && target < nums[middle]) {
                // 执行二分查找
                return Arrays.binarySearch(nums, left, middle, target);
            } else {
                return this.search(nums, middle + 1, right, target);
            }
        } else {
            // 说明middle到right是有序的
            if (nums[middle] < target && target <= nums[right]) {
                return Arrays.binarySearch(nums, middle + 1, right + 1, target);
            } else {
                return this.search(nums, left, middle - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sirs = new SearchInRotatedSortedArray();
        // int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // int[] nums = {1, 2, 4, 5, 6, 7, 0};
        int[] nums = {1, 3, 5};
        System.out.println(sirs.search(nums, 2));
    }

}
