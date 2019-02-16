### Search in Rotated Sorted Array ||

> No.81, medium

Follow up for "Search in Rotated Sorted Array":

> 1. What if duplicates are allowed?
> 2. Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

#### 分析

相对于 I 的区别在于输入元素是可以重复的，这样就需要对之前的判定做一些改进，只有当 num[left] < num[middle] 才认为是有序的，等于的时候不能这样假设，右边也一样，举个例子：`{1, 3, 1, 1, 1}`，当 middle = 2 时，我们无法判断哪边是有序的，这个时候不妨再尝试着递归一遍。

#### 实现

```java
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
```