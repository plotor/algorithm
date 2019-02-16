package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * 200. Number of Islands
 *
 * @author zhenchao.wang 2017-09-23 10:59
 * @version 1.0.0
 */
public class NumberOfIslands {

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
     *
     * @param grid
     * @param i
     * @param j
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

    public static void main(String[] args) {
        char[][] grid = {{'1', '0', '1', '1', '0', '1', '1'}};//, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        NumberOfIslands islands = new NumberOfIslands();
        System.out.println(islands.numIslands(grid));
        System.out.println(Arrays.toString(grid[0]));
    }

}
