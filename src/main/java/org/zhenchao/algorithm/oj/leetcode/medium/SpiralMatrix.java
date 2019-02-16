package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * @author zhenchao.wang 2017-11-04 10:31
 * @version 1.0.0
 */
public class SpiralMatrix {

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

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        // int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(matrix));
    }

}
