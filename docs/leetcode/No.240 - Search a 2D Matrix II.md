### Search a 2D Matrix II

> No.240, medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

Given `target = 5`, return `true`.

Given `target = 20`, return `false`.

#### 分析

题目的意思给定一个从左到右，从上到下递增的二维矩阵，寻找目标值，这道题目采用二分查找的话会比较繁琐，有一个比较巧妙的方法，从 __右上角__ 开始：

1. 如果当前的数比目标值要大的话，说明这一列都不可能，因为列上是递增的
2. 如果当前的数比目标值要小的话，说明这一行都不可能，因为行上是递减的

#### 实现

```java
public boolean searchMatrix(int[][] matrix, int target) {
    if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) return false;

    // 从右上角开始
    int i = 0, j = matrix[0].length - 1;
    for (; i < matrix.length && j >= 0; ) {
        for (; j >= 0 && i < matrix.length; ) {
            if (matrix[i][j] > target) {
                // 如果当前值大于 target，说明这一列都不可能
                j--;
            } else if (matrix[i][j] < target) {
                // 如果当前值小于 target，说明这一行都不可能
                i++;
            } else {
                return true;
            }
        }
    }
    return false;
}
```