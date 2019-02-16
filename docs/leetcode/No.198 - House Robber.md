### House Robber

> No.198, easy

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

#### 分析

题目的意思是从一个数组中选择一定的元素，不允许连续取邻接的两个，保证最后得到的数之和最大。

#### 实现

```java
/**
 * 动态规划
 * dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i])
 *
 * @param nums
 * @return
 */
public int rob(int[] nums) {
    if (null == nums || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] result = new int[nums.length];
    result[0] = nums[0];
    result[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
        result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
    }
    return result[nums.length - 1];
}
```