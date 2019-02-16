### Set Matrix Zeroes
> No.73, medium

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

#### 分析

题目要求 __原地__ 对矩阵中的 0 元素所在的行和列全部置为 0。这道题目的解法还是比较巧妙的，主要是采用第一行和第一列元素作为标志位。基本阶梯思路：

1. 采用两个标记位 hasZeroFirstRow 和 hasZeroFirstColumn 分别标记第一行和第一列是否存在 0
2. 逐行遍历剩余元素，如果为 0 的话就将对应第一行和第一列的位置置为 0
3. 逐行遍历剩余元素，如果对应的第一行或第一列为 0，则将当前位置元素置为 0
4. 依据 hasZeroFirstRow 和 hasZeroFirstColumn 标记判断是否需要将第一行和第一列全部置为 0

![image](http://2.bp.blogspot.com/-IHJ0U0dY2Is/Vn5WAgN4Y_I/AAAAAAAANN4/lJtdzyVmWCg/s640/123.png)

#### 实现

```java
public void setZeroes(int[][] matrix) {
    int rowLength = matrix.length;
    if (rowLength == 0) return;
    int colLength = matrix[0].length;
    if (colLength == 0) return;

    boolean hasZeroFirstRow = false, hasZeroFirstColumn = false;

    // 判断第一行是否存在 0
    for (int j = 0; j < colLength; ++j) {
        if (matrix[0][j] == 0) {
            hasZeroFirstRow = true;
            break;
        }
    }
    // 判断第一列是否存在 0
    for (int i = 0; i < rowLength; ++i) {
        if (matrix[i][0] == 0) {
            hasZeroFirstColumn = true;
            break;
        }
    }

    // 如果某一位置的元素为 0，则在第一行和第一列上进行标记
    for (int i = 1; i < rowLength; ++i) {
        for (int j = 1; j < colLength; ++j) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // 基于第一行和第一列的标记位对剩余元素进行设置
    for (int i = 1; i < rowLength; ++i) {
        for (int j = 1; j < colLength; ++j) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
        }
    }

    // 如果第一行有 0，则置第一行为 0
    if (hasZeroFirstRow) {
        for (int j = 0; j < colLength; ++j) {
            matrix[0][j] = 0;
        }
    }
    // 如果第一列有 0，则置第一列为 0
    if (hasZeroFirstColumn) {
        for (int i = 0; i < rowLength; ++i) {
            matrix[i][0] = 0;
        }
    }
}
```
