package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.88 Merge Sorted Array
 *
 * @author zhenchao.wang 2017-6-20 22:02:03
 */
public class MergeSortedArray {

    /**
     * 既然不允许使用额外的数组，所以可以利用nums1来存储结果，这个时候可以考虑从后往前遍历来避免数组中元素的移动
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }

        // 如果是i>=0，那么数组已经有序，所以无需再做移动操作
    }

}
