### 题目

Given an unsorted integer array, find the first missing positive integer.

For example,
Given `[1,2,0]` return `3`,
and `[3,4,-1,1]` return `2`.

Your algorithm should run in `O(n)` time and uses constant space.

### 分析

题目的意思是给定一个无序数组，然后找出第一个不连续的正数，时间复杂度要为 `O(n)`，空间复杂度需要控制在常数范围内。

时间复杂度的要求暗示这道题目只能遍历常数趟，不能使用额外的空间则只能在原数组上操作。我们最终是要找到不连续的第一个正数，这里需要明白，如果正数不是以 1 开头，那么不管后面有多连续，都是返回 1，这样就保证所有 __大于等于__ 数组长度的数都可以忽略，所有非正数也可以忽略。我们可以将其余的数放置在数组合适的位置，因为第一个数字为 1，所以 0 号位置就放置 1，由此可知正常情况下 a[i] == i+1，如果某个位置不满足这个条件，那么就是那个不连续的数。

### 实现

```java
public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) return 1;
    int len = nums.length;
    for (int i = 0; i < len; ) {
        if (nums[i] <= 0 || nums[i] >= len || nums[i] == (i + 1)) {
            // 如果是非正数，或者位于正确位置的数，或者大于数组长度的数，直接continue
            i++;
            continue;
        }
        // 交换 nums[tmp-1] 和 nums[i]
        int tmp = nums[i];
        if (nums[tmp - 1] == nums[i]) {
            // 如果 nums[tmp-1] == nums[i]，则跳过，否则陷入死循环
            i++;
            continue;
        }
        nums[i] = nums[tmp - 1];
        nums[tmp - 1] = tmp;
    }
    // System.out.println(Arrays.toString(nums));
    for (int i = 0; i < len; i++) {
        if (nums[i] != (i + 1)) {
            return i + 1;
        }
    }
    return len + 1;
}
```