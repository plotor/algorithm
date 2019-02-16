package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * @author zhenchao.wang 2017-06-12 21:09
 * @version 1.0.0
 */
public class SearchA2DMatrixII {

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

    public static void main(String[] args) {
        SearchA2DMatrixII sm = new SearchA2DMatrixII();
        int[][] matrix = {
            /*{1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},*/
            {18, 21, 23, 26, 30}
        };

        System.out.println(sm.searchMatrix(matrix, 18));

    }

}
