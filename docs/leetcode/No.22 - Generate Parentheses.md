### Generate Parentheses

> No.22, medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
```text
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

#### 分析

题目的意思是给定一个数 n，代表 n 对括号 “()”，枚举出所有合法的组合情况。

这道题可以采用 __深度优先搜索__ 的思想，脑海中设想一个 2n 个结点的图，其中一半的元素是 ‘(’，另外一半的元素是 ‘)’，然后进行深度优先搜索。

#### 实现

```java
/**
 * 采用递归实现，深度优先搜索
 *
 * @param n
 * @return
 */
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    String item = "";
    this.dfs(result, item, n, n);
    return result;
}

private void dfs(List<String> result, String item, int left, int right) {
    if (left > right) {
        // left > right 说明右括号多了，这个时候无法修正了，因为只能在尾部追加，出现了“)(”
        return;
    }
    if (0 == left && 0 == right) {
        // 一次递归完成
        result.add(item);
        return;
    }

    if (left > 0) {
        this.dfs(result, item + '(', left - 1, right);
    }
    if (right > 0) {
        this.dfs(result, item + ')', left, right - 1);
    }
}
```
