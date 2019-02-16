### Search for a Range

> No.34, medium

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of `O(log n)`.

If the target is not found in the array, return `[-1, -1]`.

For example,

Given `[5, 7, 7, 8, 8, 10]` and target value 8,

return `[3, 4]`.

#### 分析

题目的意思是给定一个有序的数组和一个目标数字 target，找出 target 在数组中的下标范围，时间复杂度要求 `O(log n)`。

这道题目显然是需要用二分查找来解决的，不过普通的二分查找只能返回目标值是否存在，这里需要找到的是目标值的范围，实际上也就是寻找左右边界，解题思路是我们可以先利用二分查找找到第一个目标值的位置，然后以此为界分别向左向右寻找左下界和右上界，当然这个检索的过程也是二分查找的过程，而不能是逐个比较的过程，这样会超时。向左检索时，如果当前位置的向左一个位置的值仍然是目标值，就继续二分查找，向右也是如此，直到找到一个值，它的左边的值不是目标值，或者当前下标已是数组边界为止。

#### 实现

```java
/**
 * 分别二分查找左右边界
 *
 * @param nums
 * @param target
 * @return
 */
public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    int index = this.search(nums, 0, nums.length - 1, target);
    if (index == -1) {
        return result;
    }

    // 查找左边界
    int left = index;
    while (left > 0 && nums[left] == nums[left - 1]) {
        // 进入进来表明左边一位必定等于目标值，所以left - 1，降低检索时间（同时避免死循环）
        left = this.search(nums, 0, left - 1, target);
    }
    result[0] = left;

    // 查找右边界
    int right = index;
    while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
        // 进入进来表明右边一位必定等于目标值，所以right + 1，降低检索时间（同时避免死循环）
        right = this.search(nums, right + 1, nums.length - 1, target);
    }
    result[1] = right;
    return result;
}

/**
 * 二分查找
 *
 * @param nums
 * @param start
 * @param end
 * @param target
 * @return
 */
public int search(int[] nums, int start, int end, int target) {
    if (end < start) return -1;
    int mid = (start + end) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] > target) {
        return this.search(nums, start, mid - 1, target);
    } else {
        return this.search(nums, mid + 1, end, target);
    }
}
```