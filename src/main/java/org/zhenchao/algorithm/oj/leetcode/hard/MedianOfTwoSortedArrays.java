package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * No.4 Median of Two Sorted Arrays
 *
 * @author zhenchao.wang 2017-04-24 21:25
 * @version 1.0.0
 */
public class MedianOfTwoSortedArrays {

    /**
     * 求两个有序数组的中间值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int sum = m + n;
        if ((sum & 0x1) == 1) {
            /*
             * sum是奇数
             * 对于奇数而言，中间值就是排在（sum / 2） + 1 位置的数
             */
            return this.findKth(nums1, 0, m - 1, nums2, 0, n - 1, sum / 2 + 1);
        } else {
            /*
             * sum是偶数
             * 对于偶数而言，中间值对应最中间两个数的和求平均，也就是 ((sum / 2） + (sum / 2 + 1)) / 2.0
             */
            return (this.findKth(nums1, 0, m - 1, nums2, 0, n - 1, sum / 2) +
                this.findKth(nums1, 0, m - 1, nums2, 0, n - 1, sum / 2 + 1)) / 2.0;
        }
    }

    /**
     * 采用二分思想，求两个数组中第k大的数
     *
     * @param a
     * @param aStart
     * @param aEnd
     * @param b
     * @param bStart
     * @param bEnd
     * @param k
     * @return
     */
    private double findKth(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int k) {
        int m = aEnd - aStart + 1, n = bEnd - bStart + 1;
        if (m > n) {
            // 始终保证 m <= n
            return this.findKth(b, bStart, bEnd, a, aStart, aEnd, k);
        }
        if (m == 0) {
            // 其中一个数组为空，则只需要考虑其中一个数组就行
            return b[k - 1];
        }
        if (k == 1) {
            // k == 1，也就是求最小的值
            return Math.min(a[aStart], b[bStart]);
        }

        int ia = Math.min(k / 2, m), ib = k - ia;
        if (a[aStart + ia - 1] < b[bStart + ib - 1]) {
            // 砍掉a[aStart, aStart + ia-1]
            return this.findKth(a, aStart + ia, aEnd, b, bStart, bEnd, k - ia);
        } else if (a[aStart + ia - 1] > b[bStart + ib - 1]) {
            // 砍掉b[bStart, bStart + ib - 1]
            return this.findKth(a, aStart, aEnd, b, bStart + ib, bEnd, k - ib);
        } else {
            return a[aStart + ia - 1];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays mtsa = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3, 7, 8, 11};
        int[] nums2 = {2, 3, 4, 7, 19, 21};
        System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
    }

}
