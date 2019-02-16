package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * @author zhenchao.wang 2017-10-23 21:32
 * @version 1.0.0
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final String[] DICT = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) return result;

        return result;
    }

    private void recursion(String digits, int start, List<Character> tmp) {
        if (start == digits.length()) {

        }
    }

}
