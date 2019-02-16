### 题目

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,  
If n = 4 and k = 2, a solution is:

```
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

### 分析

题目的意思是给定一个取值范围 n，生成所有大小为 k 的数列，不考虑顺序。

这个题目本质上是 DFS 的思想，采用递归实现，属于 NP 难问题，在时间复杂度上没有好的优化空间。

### 实战

```java
private List<List<Integer>> result = new ArrayList<List<Integer>>();

public List<List<Integer>> combine(int n, int k) {
    this.recursion(new ArrayList<Integer>(), 1, n, k);
    return result;
}

private void recursion(List<Integer> list, int start, int n, int k) {
    if (k == list.size()) {
        result.add(new ArrayList<Integer>(list));
        return;
    }
    for (int i = start; i <= n; i++) {
        list.add(i);
        this.recursion(list, i + 1, n, k);
        list.remove(list.size() - 1);
    }
}
```