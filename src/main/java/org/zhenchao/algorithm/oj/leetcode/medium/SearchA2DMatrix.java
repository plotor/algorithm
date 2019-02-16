package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.74 Search a 2D Matrix
 *
 * @author zhenchao.wang 2017-06-11 17:37
 * @version 1.0.0
 */
public class SearchA2DMatrix {

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

    public static void main(String[] args) {
        SearchA2DMatrix sm = new SearchA2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(sm.searchMatrix(matrix, 51));
    }

}
