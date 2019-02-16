### Find Minimum in Rotated Sorted Array II

> No.154, hard

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Find the minimum element.

The array may contain duplicates.

#### 分析


相对于 I 的区别在于这里的数组允许有重复元素。

#### 实现

```java
public int findMin(int[] nums) {
    return this.binarySearch(nums, 0, nums.length - 1);
}

private int binarySearch(int[] nums, int start, int end) {
    if (end <= start) return nums[end];
    int mid = (start + end) / 2;
    if (nums[mid] > nums[end]) {
        return this.binarySearch(nums, mid + 1, end);
    } else if (nums[mid] < nums[end]) {
        return this.binarySearch(nums, start, mid);
    } else {
        // 此时不能保证 nums[start] 也等于 nums[mid], 所以需要再判断一次
        return nums[start] < nums[mid] ?
                nums[start] : Math.min(this.binarySearch(nums, start + 1, mid), this.binarySearch(nums, mid, end - 1));
    }
}
```