package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 *
 * @author zhenchao.wang 2017-11-25 09:54
 * @version 1.0.0
 */
public class SetMatrixZeroes {

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

    public static void main(String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrix = {{1, 1, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}};
        smz.setZeroes(matrix);
        for (final int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

}
