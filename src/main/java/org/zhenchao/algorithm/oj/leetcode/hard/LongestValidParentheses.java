package org.zhenchao.algorithm.oj.leetcode.hard;

import java.util.Stack;

/**
 * No.32 Longest Valid Parentheses
 *
 * @author zhenchao.wang 2017-05-06 10:16
 * @version 1.0.0
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(' ', -1));
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 如果是左括号，则直接入栈
                stack.push(new Pair('(', i));
            } else {
                // 如果是右括号
                if ('(' == stack.peek().c) {
                    // 当前栈顶是“(”
                    stack.pop();
                    max = Math.max(max, i - stack.peek().index);
                } else {
                    stack.push(new Pair(')', i));
                }
            }
        }
        return max;
    }

    private class Pair {
        char c;
        int index;

        public Pair(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        String s = ")()())()()(";
        System.out.println(lvp.longestValidParentheses(s));
    }

}
