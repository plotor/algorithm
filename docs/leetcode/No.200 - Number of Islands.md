### Number of Islands

> No.199, medium

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

```
11110
11010
11000
00000
```

Answer: 1

Example 2:

```
11000
11000
00100
00011
```

Answer: 3

#### 分析

#### 实现

```java
public int numIslands(char[][] grid) {
    if (null == grid || grid.length == 0 || grid[0].length == 0) return 0;
    int count = 0;
    int y = grid.length, x = grid[0].length;
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            if (grid[i][j] == '1') {
                count++;
                this.mark(grid, i, j);
            }
        }
    }
    return count;
}

/**
 * 标记邻近的结点
 */
private void mark(char[][] grid, int i, int j) {
    int y = grid.length, x = grid[0].length;
    if (i < 0 || i >= y || j < 0 || j >= x || '1' != grid[i][j]) return;
    grid[i][j] = '0';
    this.mark(grid, i - 1, j);
    this.mark(grid, i + 1, j);
    this.mark(grid, i, j - 1);
    this.mark(grid, i, j + 1);
}
```
