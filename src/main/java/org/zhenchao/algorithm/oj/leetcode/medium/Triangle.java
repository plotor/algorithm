package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.List;

/**
 * 120. Triangle
 *
 * @author zhenchao.wang 2017-08-05 11:04
 * @version 1.0.0
 */
public class Triangle {

    /**
     * 动态规划
     * 需要注意的是题目并不是要选每一行的最小值，每次只能选择当前元素下一行临近的两个元素，即 [i + 1][j] 和 [i + 1][j + 1]
     * 所以这道题需要自底而上来计算
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0 || triangle.get(triangle.size() - 1).size() == 0) return 0;
        int height = triangle.size();
        int[] sum = new int[triangle.get(height - 1).size()];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = triangle.get(height - 1).get(i);
        }
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }
        return sum[0];
    }

}
