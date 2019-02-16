### 题目

Given a collection of distinct numbers, return all possible permutations.

For example,

`[1,2,3]` have the following permutations:

```
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

### 分析

题目的意思是给定一个数组，实现由数组元素构成的全排列。

这种题目没有什么高效的解法，只能递归调用，但是需要借助一个 visited 数组标记已经访问过的元素。

### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> permute(int[] nums) {
    int[] visited = new int[nums.length];
    this.recursion(nums, visited, new ArrayList<Integer>());
    return result;
}

private void recursion(int[] nums, int[] visited, List<Integer> list) {
    if (list.size() == nums.length) {
        result.add(new ArrayList<Integer>(list));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (visited[i] == 0) {
            list.add(nums[i]);
            visited[i] = 1;
            this.recursion(nums, visited, list);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

}
```