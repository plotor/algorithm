### Find Minimum in Rotated Sorted Array

> No.153, medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Find the minimum element.

You may assume no duplicate exists in the array.

#### 分析


题目的意思是给定一个被 “平移” 处理过后的有序数组，从中找出最小的元素，典型的二分查找应用场景。

#### 实现

```java
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
```