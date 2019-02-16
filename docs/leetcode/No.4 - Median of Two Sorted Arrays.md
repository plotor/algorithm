### Median of Two Sorted Arrays

> No.4, hard

There are two sorted arrays `nums1` and `nums2` of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be `O(log(m+n))`.

Example 1:

```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```

Example 2:

```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

#### 分析

这道题目可以泛化为 __求两个有序数组中第 k 大的数__，如果没有实现复杂度限制，最简单的做法就是用一个计数器 h，依次从左向右比较两个数组对应的值，较小的数组的指针前进一位，当 h == k 时就找到了第 k 大的数，这样的时间复杂度是 `O(m + n)`。

本题是求中间值，即 k = (m + n) / 2，并且要求时间复杂度是 `O(log(m+n))`，所以上述思想不符合要求，不过看这样的时间复杂度要求，我们就应该想到是要用二分查找去做。这里需要考虑一个思路，__如果数组 A 和 B 满足，A[k / 2 - 1] < B [k / 2 -1]，那么第 k 大的数绝对不可能出现在 A[0, k / 2 - 1] 中__，所以这时我们就可以将 A[0, k / 2 - 1] 砍掉，然后继续在剩下的元素中查找，不过这个时候的 k 应该更新为 `k = k - k / 2 - 1`，因为刚刚已经砍掉了 k / 2 - 1 个元素。

#### 实现

```java
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
```
