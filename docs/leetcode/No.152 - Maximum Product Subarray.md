### Maximum Product Subarray

> No.152, medium

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array `[2,3,-2,4]`,  
the contiguous subarray `[2,3]` has the largest product = 6.

#### 分析

题目的意思是从给定的数组中找到一个连续的子数组，保证子数组中元素的乘积最大。

解题思路比较讨巧，设置两个大小为 nums 长度的数组 max 和 min，max[0] 和 min[0] 都为 nums[0]，然后从 1 位置开始遍历 nums，并按照如下伪代码更新 max 和 min：

```java
if (nums[i] > 0) {
    max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
    min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
} else {
    max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
    min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
}
```

期间利用一个值记录最大的乘积值，就是我们最后要的结果。如下是示例对应的 max 和 min 计算步骤：

- | 0 | 1 | 2 | 3
--- | --- | --- | --- | ---
nums | 2 | 3 | -2 | 4
max | 2 | 6 | -2 | 4
min | 2 | 6 | -2 | 4


#### 实现

```java
public int maxProduct(int[] nums) {
    if (null == nums || nums.length == 0) return 0;
    int[] max = new int[nums.length], min = new int[nums.length];
    int result = max[0] = min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > 0) {
            max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
            min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
        } else {
            max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
            min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
        }
        result = Math.max(result, max[i]);
    }
    return result;
}
```