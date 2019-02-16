package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * @author zhenchao.wang 2017-09-02 10:57
 * @version 1.0.0
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (null == tokens || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (final String token : tokens) {
            if (this.isOperator(token)) {
                this.operate(token, stack);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    private void operate(String operator, Stack<Integer> stack) {
        int a = stack.pop(), b = stack.pop();
        if ("+".equals(operator)) {
            stack.push(a + b);
        } else if ("-".equals(operator)) {
            stack.push(b - a);
        } else if ("*".equals(operator)) {
            stack.push(a * b);
        } else if ("/".equals(operator)) {
            stack.push(b / a);
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        // String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(erpn.evalRPN(tokens));
    }

}
