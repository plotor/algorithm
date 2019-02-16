### Search in Rotated Sorted Array

> No.33, medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

#### 分析

题目的意思是指给定一个数组，这个数组原先是有序的，但是可能向左平移了一定的单位，导致比如 `0 1 2 4 5 6 7` 变成了 `4 5 6 7 0 1 2` 这样的排列，但是我们不知道向左到底平移了几格，然后在这样的数组中寻找目标数 target 的下标，如果找不到就返回 -1。

这类题目是二分查找的变种，二分查找是在一个有序数组里面查找目标值，但是这里的数组是被平移过的，但是仍然是部分有序的，所以思路如下：

假设有数组 nums，且 left，middle，right 分别指向数组的左、中、右位置，那么有：

1. 如果 nums[left] <= nums[middle]，则说明 nums[left, middle] 是有序的，如果 target 的值在这个范围内，则可以直接利用二分查找，如果不在这个范围内，则说明可能在 nums[middle+1, right] 范围内，但是这个子数组不一定是有序的，可能是类似于之前数组的一个子集，这个时候我们套用递归即可。
2. 如果nums[left] > nums[middle]，这说明 nums[middle, right] 是有序的，接下去的解决思路同上。

#### 实现

```java
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
```