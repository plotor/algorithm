### Maximum Subarray

> No.53, easy

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array `[-2,1,-3,4,-1,2,1,-5,4]`,

the contiguous subarray `[4,-1,2,1]` has the largest sum = `6`.

#### 分析

题目的意思找给定一个数组，找出一个连续的子数组，使子数组中的 sum 最大，返回 sum。

这道题目的一个巧妙实现是 Kadane 算法，基本过程是，从头遍历数组，然后用一个 sum 记录遍历元素的和，如果 sum < 0，则清空 sum，即 sum = 0，并继续遍历，过程中用 max 记录最大的 sum。

#### 实现

```java
public int maxSubArray(int[] nums) {
    int max = nums[0];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        max = Math.max(max, sum);
        if (sum <= 0) sum = 0;
    }
    return max;
}
```