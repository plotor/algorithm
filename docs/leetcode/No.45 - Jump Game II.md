### 题目

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:

Given array A = `[2,3,1,1,4]`

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

### 分析

题目的意思是给定一个数组，然后找到从起点到终点的最短跳数。

这个题目需要借鉴 `No.55 Jump Game` 的思想，给定一个与原始数组一样长的数组 dis，其中记录每个位置当前能够到达的最远的距离，比如 `[2,3,1,1,4]`

nums[] | 2 | 1 | 1 | 3 | 4
-- | -- | -- | -- | -- | --
dis[] | 2 | 2 | 3 | 4 | 4

得到 dis 数组之后，我们就可以采用贪心的方法，每一步走跨的最大，这样就可以以最少的步数达到终点。

### 实现

```java
public int jump(int[] nums) {
    if (nums.length == 1) return 0;
    int max = 0;
    // 计算当前各个位置能够到达的最远距离
    int[] dis = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        max = Math.max(max, i + nums[i]);
        dis[i] = Math.min(max, nums.length - 1);
    }

    // System.out.println(Arrays.toString(dis));
    int count = 0;
    int i = 0;
    // 每一步都跨的最大
    for (; i < dis.length - 1 && dis[i] != dis.length - 1; ) {
        i = dis[i];
        count++;
    }
    if (i < dis.length) count++;
    return count;
}
```