### 题目

Given a collection of candidate numbers (`C`) and a target number (`T`), find all unique combinations in `C` where the candidate numbers sums to `T`.

Each number in `C` may only be used once in the combination.

Note:

- All numbers (including target) will be positive integers.
- The solution set must not contain duplicate combinations.

For example, given candidate set `[10, 1, 2, 7, 6, 1, 5]` and target `8`, 
A solution set is: 

```
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

### 分析

相对于 Combination Sum 的区别在于这里的数字是不能重复利用，同时输入数组也引入了重复数字，思路还是和 Combination Sum 相同，但是需要注意去重。

### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
    int pre = -1; // 记录前一个元素
    for (int i = index; i < nums.length && nums[i] <= target; i++) {
        // 如果当前元素与之前的相同，则跳过
        if (nums[i] <= target && pre != nums[i]) {
            list.add(nums[i]);
            this.search(nums, i + 1, target - nums[i], list);
            // 删除无效的追加元素，继续回溯查找
            list.remove(list.size() - 1);
            pre = nums[i];
        }
    }
}
```