### Spiral Matrix II

> No.59, medium

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example, given n = 3,

You should return the following matrix:

```
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```

#### 分析

题目 I 是按照螺旋的顺序打印矩阵，而这里是按照螺旋的顺序填充矩阵。解题思路同样是按照 __从左到右、从上到下、从右到左、从下到上__ 的顺序逐一填充，这里需要注意的是如果 n 是奇数，那么最中心的元素在循环填充过程中无法触及，需要单独进行填充。

#### 实现

```java
public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    // 如果n是奇数，则需要填充矩阵最中心
    if (n % 2 == 1) matrix[n / 2][n / 2] = n * n;

    // 开始填充螺旋矩阵
    int val = 1, x = 0, y = 0;
    while (n > 0) {
        // 1.从左到右
        for (int i = 0; i < n - 1; i++) {
            matrix[x][y++] = val++;
        }
        // 2.从上到下
        for (int i = 0; i < n - 1; i++) {
            matrix[x++][y] = val++;
        }
        // 3. 从右到左
        for (int i = 0; i < n - 1; i++) {
            matrix[x][y--] = val++;
        }
        // 4. 从下到上
        for (int i = 0; i < n - 1; i++) {
            matrix[x--][y] = val++;
        }
        x++;
        y++;
        n -= 2;
    }
    return matrix;
}
```