package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * 125. Valid Palindrome
 *
 * @author zhenchao.wang 2015-10-3 13:52:43
 * @version 1.0.0
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (null == s) return false;
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            char left = s.charAt(i);
            if (!this.isAlphanumeric(left)) {
                ++i;
                continue;
            }
            char right = s.charAt(j);
            if (!this.isAlphanumeric(right)) {
                --j;
                continue;
            }
            if (left != right) return false;
            ++i;
            --j;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("ab2a"));
    }
}
