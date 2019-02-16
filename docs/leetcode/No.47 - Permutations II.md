### 题目

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,

`[1,1,2]` have the following unique permutations:

```
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

### 分析

这道题目相对于前一题的唯一区别在于结果不能重复，所以需要进行去重处理。

### 实现

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);  // 排序
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
        if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0) continue; // 去重
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