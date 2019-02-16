### Remove Element

> No.27, easy

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this __in place__ with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = `[3,2,2,3]`, val = `3`

Your function should return length = 2, with the first two elements of nums being 2.

#### 分析

题目要求给定一个数组和目标值，返回数组中非目标值元素的个数，同时将所有非目标值移动到数组的前端。

我们可以设置一个指针 right，始终指向数组最后一个非目标元素，然后从数组前面开始往后遍历，当遇到目标值的时候，就将其替换成指针此时所指向的元素，然后继续遍历。

#### 实现

```java
public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
        return 0;
    }

    int right = nums.length - 1;
    for (int left = 0; left <= right; left++) {
        // 保证left始终指向最后一个非目标元素
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        if (nums[left] == val && left < right) {
            nums[left] = nums[right--]; // 无需考虑组织顺序
        }
    }

    return right + 1;
}
```