package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * No.58 Length of Last Word
 *
 * @author zhenchao.wang 2017-5-31 20:49:19
 * @version 1.0.0
 */
public class LengthOfLastWord {

    /**
     * 从前向后遍历，不推荐
     */
    /*public int lengthOfLastWord(String s) {

        int len = 0;
        if(s == null) {
            return len;
        }
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ') {
                len++;
            } else {
                len = 0;
            }
        }

        return len;

    }*/

    /**
     * 从后往前遍历计数
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null) {
            return len;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && len != 0) {
                break;
            } else if (s.charAt(i) != ' ') {
                len++;
            }
        }

        return len;
    }

}
