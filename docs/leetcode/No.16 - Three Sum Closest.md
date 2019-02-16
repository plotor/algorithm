### Three Sum Closest

> No.16, medium

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

_You may assume that each input would have exactly one solution._

```text
For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

#### 分析

该题要求在给定数组中寻找 3 个数，要求这三个数之和 __最接近__ 给定的数 target，包含了等于。题目只要求返回近似的和，不是具体的 3 个数，所以要简单很多，基本思路也是先对数组按从小到大排序，然后从用 3 个指以左边的数为基数，移动操作右边两个指针，当小于 target 时移动左指针，当大于 target 时移动右指针，同时记录过程中绝对值最小的差值以及对应的 sum，当整个遍历过程执行完后，sum 记录的值就是我们的目标值。

#### 实现

```java
public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums); // 先对数组进行排序
    int closest = Integer.MAX_VALUE; // 记录当前最小的与 target 之差的绝对值
    int sum = 0;
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int tSum = nums[left] + nums[right] + nums[i];
            int tClosest = Math.abs(target - tSum);
            if (tSum == target) {
                return tSum; // 找到相等的，直接返回
            } else if (tSum > target) { // 当前之和大于 target
                right--;
            } else {
                left++; // 当前之和小于 target
            }
            if (tClosest < closest) {
                sum = tSum;
                closest = tClosest;
            }
        }
    }
    return sum;
}
```