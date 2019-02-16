package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * No.20
 *
 * @author zhenchao.wang 2016-09-25 10:52
 * @version 1.0.0
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if (null == s || "".equals(s) || s.length() == 1) {
            return false;
        }

        Set<Character> left = new HashSet<Character>() {
            {
                this.add('{');
                this.add('(');
                this.add('[');
            }
        };

        Map<Character, Character> pair = new HashMap<Character, Character>() {
            {
                this.put('{', '}');
                this.put('(', ')');
                this.put('[', ']');
            }
        };

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.contains(c)) {
                stack.add(c);
                continue;
            }

            if (stack.size() == 0 || !pair.get(stack.pop()).equals(c)) {
                return false;
            }

        }

        return stack.size() == 0 ? true : false;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String str = "[])";
        System.out.println(vp.isValid(str));
    }

}
