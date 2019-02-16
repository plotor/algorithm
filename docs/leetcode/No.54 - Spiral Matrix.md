### Spiral Matrix

> No.54, medium

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,  
Given the following matrix:

```
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
```

You should return `[1,2,3,6,9,8,7,4,5]`.

#### 分析

题目的意思是给定一个二维矩阵，然后采用螺旋的方式打印该矩阵。

基本思路是基于螺旋的规律修改横坐标和纵坐标值，以达到螺旋的目的。设置一个 m 和 n 值用于记录当前数组在纵向和横向上剩余的元素个数，然后用一个 x 和 y 值记录每次旋转前的坐标起始值，实际上每次旋转一圈，m 和 n 的值就会减去 2，而 x 和 y 的值则会加 1，需要注意的一点就是当 m 或 n 等于 1 时就需要停止旋转，将剩下的元素全部写入结果集中，退出循环返回。

#### 实现

```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<Integer>();
    if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
        return list;
    }
    int m = matrix.length, n = matrix[0].length;
    // x 和 y 用于标记每次转圈之前的起点值，（0,0）（1,1）...
    int x = 0, y = 0;
    while (m > 0 && n > 0) {
        if (m == 1) {
            // 只有一行
            for (int i = 0; i < n; i++) {
                list.add(matrix[x][y++]);
            }
            break;
        }
        if (n == 1) {
            // 只有一列
            for (int i = 0; i < m; i++) {
                list.add(matrix[x++][y]);
            }
            break;
        }

        // 1. 从左到右
        for (int i = 0; i < n - 1; i++) {
            list.add(matrix[x][y++]);
        }
        // 2. 从上到下
        for (int i = 0; i < m - 1; i++) {
            list.add(matrix[x++][y]);
        }
        // 3. 从右到左
        for (int i = 0; i < n - 1; i++) {
            list.add(matrix[x][y--]);
        }
        // 4. 从下到上
        for (int i = 0; i < m - 1; i++) {
            list.add(matrix[x--][y]);
        }

        // 每转一圈，纵向和横向上的起点都要加1
        x++;
        y++;

        // 每转一圈，纵向和横向上的元素个数都要减2
        m -= 2;
        n -= 2;
    }

    return list;
}
```