### Three Sum

> No.15, medium

Given an array S of n integers, are there elements a, b, c in S such that `a + b + c = 0`? Find all unique triplets in the array which gives the sum of zero.

__Note__: The solution set must not contain duplicate triplets.

```text
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

#### 分析

题目的意思是给定一个数组，从中找出 __所有__ 满足和为 0 的三元组，之前的 Two Sum 是要求我们从一个数组中找出 __任一一对满足和为 0 的二元组的下标__，注意区别。

如果我们把 Two Sum 的要求变一下，也是求所有满足和为 0 的二元组，那么可以从三个方面切入：

> 1. 暴力枚举
> 2. 先将所有的元素全部存放到一个 hashset 中，然后遍历数组
> 3. 先对数组进行排序，然后用首尾指针进行遍历

这三种方法里面当然是第 3 种解法最优雅，《编程之美》也主张第 3 种，所以我们着重来看第 3 种。这种方法的基本思想是先对数组从小到大排序，然后用一个首尾指针，计算当前指针位置的元素之和是否为 0，如果大于 0 则尾指针左移，如果小于 0，则左指针右移，如果相等，则两个指针同时移动一格，这个时候需要判断移动之后的元素是否等于之前的元素，如果是则需要继续按既定的方向移动，以去重。

Three Sum 的解法可以基于 Two Sum 来做，实际上就是把 Three Sum 分解成一个基数，然后求另外两个元素的 Two Sum 问题。

#### 实现

```java
/**
 * 基于 Two Sum 解 Three Sum
 *
 * @param nums
 * @return
 */
public List<List<Integer>> threeSum(int[] nums) {
    if (null == nums || nums.length < 3) {
        return new ArrayList<List<Integer>>();
    }
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int pre = nums[0];
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == pre) {
            // 去重
            continue;
        }
        pre = nums[i];
        List<List<Integer>> inner = this.twoSum(nums, i + 1, -nums[i]);
        if (inner.size() > 0) {
            list.addAll(inner);
        }
    }
    return list;
}

private List<List<Integer>> twoSum(int[] nums, int start, int target) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int left = start, right = nums.length - 1;
    while (left < right) {
        int value = nums[left] + nums[right];
        if (value < target) {
            left++;
        } else if (value > target) {
            right--;
        } else {
            list.add(Arrays.asList(-target, nums[left], nums[right]));
            left++;
            // 去重
            while (left < right && nums[left] == nums[left - 1]) left++;

            right--;
            // 去重
            while (left < right && nums[right] == nums[right + 1]) right--;
        }
    }
    return list;
}
```