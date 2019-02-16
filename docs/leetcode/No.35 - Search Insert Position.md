### Search Insert Position

> No.35, easy

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

```
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
```

#### 分析

题目要求给定一个有序数组和一个目标数值 target，然后找到 target 在数组中的插入位置，保证插入后原数组仍然有序。这道题目可以顺序遍历，但是较好的方式还是二分查找，这样时间复杂度会小一些。

#### 实现

```java
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
```