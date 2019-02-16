### 题目

Given a set of candidate numbers (`C`) (__without duplicates__) and a target number (`T`), find all unique combinations in C where the candidate numbers sums to `T`.

__The same repeated number may be chosen from C unlimited number of times.__

Note:

- All numbers (including target) will be positive integers.
- The solution set must not contain duplicate combinations.
- 
For example, given candidate set `[2, 3, 6, 7]` and target `7`, 
A solution set is: 

```
[
  [7],
  [2, 2, 3]
]
```

### 分析

题目的意思是给定一个数组，和一个目标值 target，从数组中找到所有和等于 target 的组合，一个数字可以无限重复使用。

这种属于 NP 问题，没有太高效的解决方法，简单的回溯法(递归实现)：

比如对于数组3,2,6,7,target = 7,对数组排序得到[2,3,6,7]

> 1. 第1个数字选取2, 那么接下来就是解决从数组[2,3,6,7]选择数字且target = 7-2 = 5
> 2. 第2个数字选择2，那么接下来就是解决从数组[2,3,6,7]选择数字且target = 5-2 = 3
> 3. 第3个数字选择2，那么接下来就是解决从数组[2,3,6,7]选择数字且target = 3-2 = 1
> 4. 此时target = 1小于数组中的所有数字，失败，回溯，重新选择第3个数字
> 5. 第3个数字选择3，那么接下来就是解决从数组[2,3,6,7]选择数字且target = 3-3 = 0
> 6. target = 0，找到了一组解，继续回溯寻找其他解

### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // 先对数组排序
    Arrays.sort(candidates);
    // 递归查找
    this.search(candidates, 0, target, new ArrayList<Integer>());
    return result;
}

public void search(int[] nums, int index, int target, List<Integer> list) {
    if (target == 0) {
        // 找到一个组合
        result.add(new ArrayList<Integer>(list));
        return;
    }
    for (int i = index; i < nums.length && nums[i] <= target; i++) {
        if (nums[i] <= target) {
            list.add(nums[i]);
            this.search(nums, i, target - nums[i], list);
        }
        // 删除无效的追加元素，继续回溯查找
        list.remove(list.size() - 1);
    }
}
```