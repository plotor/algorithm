package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.77 Combinations
 *
 * @author zhenchao.wang 2017-06-15 12:17
 * @version 1.0.0
 */
public class Combinations {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        this.recursion(new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    private void recursion(List<Integer> list, int start, int n, int k) {
        if (k == list.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            this.recursion(list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        c.combine(4, 3);
        System.out.println(c.result);
    }

}
