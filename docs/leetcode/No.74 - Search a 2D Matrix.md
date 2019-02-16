### Search a 2D Matrix

> No.74, medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

```
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
```

Given `target = 3`, return `true`.

#### 分析

这道题目本质上是二分查找，只是输入的是一个二维矩阵，所以只需要控制好坐标转换就好了。

#### 实现

```java
public boolean searchMatrix(int[][] matrix, int target) {
    if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) return false;
    int length = matrix.length * matrix[0].length;
    return this.binarySearch(matrix, 0, length, target);
}

/**
 * 递归二分查找
 *
 * @param matrix
 * @param left
 * @param right
 * @param target
 * @return
 */
public boolean binarySearch(int[][] matrix, int left, int right, int target) {
    if (left > right) return false;

    // 二分查找
    int mid = (left + right) / 2;
    int[] arr = this.shift(mid, matrix[0].length);
    if (arr[0] >= matrix.length || arr[1] >= matrix[0].length) return false;

    if (matrix[arr[0]][arr[1]] == target) {
        return true;
    } else if (matrix[arr[0]][arr[1]] < target) {
        return this.binarySearch(matrix, mid + 1, right, target);
    } else {
        return this.binarySearch(matrix, left, mid - 1, target);
    }
}

/**
 * 单个整数转换成一个二维坐标
 *
 * @param index
 * @param length
 * @return
 */
private int[] shift(int index, int length) {
    int m = index / length;
    int n = index - m * length;
    // System.out.println(m + "\t" + n);
    return new int[] {m, n};
}
```