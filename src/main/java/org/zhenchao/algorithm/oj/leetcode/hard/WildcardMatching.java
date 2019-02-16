package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * No.44 Wildcard Matching
 * <url>http://shmilyaw-hotmail-com.iteye.com/blog/2154716</url>
 *
 * @author zhenchao.wang 2017-05-18 20:17
 * @version 1.0.0
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*+", "*");
        // System.out.println(p);
        if (s.length() < p.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                // 相同 or '?'
                i++;
                j++;
            } else if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '*') {
                return false;
            } else {
                // p[j] == '*'
                if (j == p.length() - 1) {
                    return true;
                }
                char t = p.charAt(j + 1);
                while (i < s.length() && s.charAt(i) != t) i++;
                j++;
            }
        }
        return i == s.length() && j == p.length();
    }

    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    }

}
