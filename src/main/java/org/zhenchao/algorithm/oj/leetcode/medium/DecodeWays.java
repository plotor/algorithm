package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * 91. Decode Ways
 *
 * @author zhenchao.wang 2017-06-26 18:05
 * @version 1.0.0
 */
public class DecodeWays {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (null == s || "".equals(s)) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = this.isValid(s.substring(0, 1)) ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            if (this.isValid(s.substring(i - 1, i))) dp[i] += dp[i - 1];
            if (this.isValid(s.substring(i - 2, i))) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int iv = Integer.parseInt(s);
        return iv >= 1 && iv <= 26;
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("01234"));
    }

}
