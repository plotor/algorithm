### Triangle

> No.120, medium

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:  
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

#### 分析

题目要求从一个矩阵中选择一条路径，保证路径上的值之和最小，需要注意的是题目并不是要选每一行的最小值，每次只能选择当前元素下一行临近的两个元素，即 [i + 1][j] 和 [i + 1][j + 1]，所以这道题需要自底而上来计算。

#### 实现

```java
/**
 * 动态规划
 * 需要注意的是题目并不是要选每一行的最小值，每次只能选择当前元素下一行临近的两个元素，即 [i + 1][j] 和 [i + 1][j + 1]
 * 所以这道题需要自底而上来计算
 *
 * @param triangle
 * @return
 */
public int minimumTotal(List<List<Integer>> triangle) {
    if (null == triangle || triangle.size() == 0 || triangle.get(triangle.size() - 1).size() == 0) return 0;
    int height = triangle.size();
    int[] sum = new int[triangle.get(height - 1).size()];
    for (int i = 0; i < sum.length; i++) {
        sum[i] = triangle.get(height - 1).get(i);
    }
    for (int i = height - 2; i >= 0; i--) {
        for (int j = 0; j < triangle.get(i).size(); j++) {
            sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j + 1]);
        }
    }
    return sum[0];
}
```
