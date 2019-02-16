### 题目

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:

A = `[2,3,1,1,4]`, return true.

A = `[3,2,1,0,4]`, return false.

### 分析

题目要求给定一个包含非负数的数组，数组中的每个值代表当前能够位置能够向前跳跃的最大步数，判断给定的数组能不能够保证从最开始的位置跳转到最后。

我们可以记录目前能够到达的最远位置值 x，如果 x 已经超过了数组的长度，则返回 true，如果出现某个位置 i，i > max，则说明无法达到最末端。

### 实现

```java
public boolean canJump(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length && i <= max; i++) {
        // 计算当前能够到达的最远结点
        max = Math.max(max, i + nums[i]);
        if (max >= nums.length - 1) return true;
    }
    return false;
}
```