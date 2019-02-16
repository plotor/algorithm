package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.35 Search Insert Position
 *
 * @author zhenchao.wang 2017-05-12 15:45
 * @version 1.0.0
 */
public class SearchInsertPosition {

    /**
     * 二分查找法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return this.binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return left;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return this.binarySearch(nums, left, mid - 1, target);
        } else {
            return this.binarySearch(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.println(sip.searchInsert(nums, 0));
    }

}
