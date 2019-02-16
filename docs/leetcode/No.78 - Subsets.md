### 题目

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

```
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

### 分析

这道题目可以看做是 77 题套了一个循环，但是有更好的解法。

### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> subsets(int[] nums) {
    result.add(new ArrayList<Integer>());
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
    }
}
```