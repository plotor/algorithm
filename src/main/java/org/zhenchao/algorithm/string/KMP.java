package org.zhenchao.algorithm.string;

/**
 * @author zhenchao.wang 2017-04-30 22:28
 * @version 1.0.0
 */
public class KMP {

    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            // 计算dfa
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            // 找到匹配（到达模式字符串的结尾）
            return i - M;
        } else {
            // 未找到匹配（到达文本字符串的结尾）
            return N;
        }
    }

    public static void main(String[] args) {
        // String haystack = "BCBAABACAABABACAA";
        // String needle = "ABABAC";
        String haystack = "BBC ABCDAB ABCDAB CDABDE";
        String needle = "ABCDABD";
        KMP kmp = new KMP(needle);
        System.out.println(kmp.search(haystack));
    }
}
