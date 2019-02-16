package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 *
 * @author zhenchao.wang 2017-11-04 12:10
 * @version 1.0.0
 */
public class SpiralMatrixII {

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

    public static void main(String[] args) {
        SpiralMatrixII sm = new SpiralMatrixII();
        int[][] matrix = sm.generateMatrix(0);
        for (final int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

}
