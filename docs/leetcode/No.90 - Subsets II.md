### 题目

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,

If nums = [1,2,2], a solution is:

```
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

### 分析

相对于 I 来说，输入存在重复元素，需要保证结果没有重复项。

首先需要对输入按照从小到大排序，然后对于重复的元素来说，只要保证跳过第三个及以后的重复项即可。

### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> subsetsWithDup(int[] nums) {
    result.add(new ArrayList<Integer>());
    Arrays.sort(nums);  // 输入不一定有序
    for (int i = 1; i <= nums.length; i++) {
        this.recursion(new ArrayList<Integer>(), 0, nums, i);
    }
    return result;
}

private void recursion(List<Integer> list, int start, int[] nums, int k) {
    if (k == list.size()) {
        result.add(new ArrayList<Integer>(list));
        return;
    }
    for (int i = start; i < nums.length; i++) {
        list.add(nums[i]);
        this.recursion(list, i + 1, nums, k);
        list.remove(list.size() - 1);
        // 相对于1，只需要添加下面一行
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
    }
}
```