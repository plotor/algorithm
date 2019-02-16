package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.22 Generate Parentheses
 *
 * @author zhenchao.wang 2017-04-29 17:13
 * @version 1.0.0
 */
public class GenerateParentheses {

    /**
     * 采用递归实现，深度优先搜索
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String item = "";
        this.dfs(result, item, n, n);
        return result;
    }

    private void dfs(List<String> result, String item, int left, int right) {
        if (left > right) {
            // left > right 说明右括号多了，这个时候无法修正了，因为只能在尾部追加，出现了“)(”
            return;
        }
        if (0 == left && 0 == right) {
            // 一次递归完成
            result.add(item);
            return;
        }

        if (left > 0) {
            this.dfs(result, item + '(', left - 1, right);
        }
        if (right > 0) {
            this.dfs(result, item + ')', left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(4));
    }

}
