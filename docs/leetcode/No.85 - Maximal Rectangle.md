### Maximal Rectangle

> No.85, hard

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

```
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

Return 6.

#### 分析

题目的意思是给定一个矩阵，寻找其中连续为 1 的最大子矩阵，实现思路还是比较巧妙的，参考《程序员代码面试指南》 P26 页。

#### 实现

```java
public int maximalRectangle(char[][] matrix) {
    if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
    int[] height = new int[matrix[0].length];
    Arrays.fill(height, 0);
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
        }
        // 每新增一排都计算一下最大值
        max = Math.max(max, this.max(height));
    }
    return max;
}

/**
 * 向左向右寻找最大可扩展区域
 *
 * @param height
 * @return
 */
private int max(int[] height) {
    int max = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < height.length; i++) {
        while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (i - k - 1) * height[j]);
        }
        stack.push(i);
    }

    // 处理栈中剩余的元素
    while (!stack.isEmpty()) {
        int j = stack.pop();
        int k = stack.isEmpty() ? -1 : stack.peek();
        max = Math.max(max, (height.length - k - 1) * height[j]);
    }
    return max;
}
```