package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * 151. Reverse Words in a String
 *
 * @author zhenchao.wang 2017-09-02 11:19
 * @version 1.0.0
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        if (null == s || s.length() == 0) return s;
        char[] cs = s.toCharArray();
        this.reverse(cs, 0, s.length() - 1);
        int start = 0, end = 0;
        for (int i = 0; i < cs.length; i++) {
            if (' ' != cs[i]) {
                end++;
            } else {
                if (end > start) {
                    this.reverse(cs, start, end - 1);
                    start = end;
                }
                start++;
                end++;
            }
        }
        this.reverse(cs, start, end - 1);
        return String.valueOf(cs).trim().replaceAll("\\s+", " ");
    }

    private void reverse(char[] cs, int start, int end) {
        while (start < end) {
            char t = cs[start];
            cs[start] = cs[end];
            cs[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInString rw = new ReverseWordsInString();
        // String s = " the   sky is blue ";
        String s = "1 ";
        System.out.println(rw.reverseWords(s));
    }

}
