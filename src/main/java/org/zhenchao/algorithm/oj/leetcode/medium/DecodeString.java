package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.common.Stack;

/**
 * 394. Decode String
 *
 * @author zhenchao.wang 2017-10-29 12:47
 * @version 1.0.0
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder decoded = new StringBuilder();
        Stack<String> ss = new Stack<String>(); // 存放字符串片段
        Stack<Integer> si = new Stack<Integer>(); // 存放重复的次数
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                // 当前为数字
                int count = 0;
                while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                si.push(count);
            } else if ('[' == c) {
                // 如果是 '[' 则将对应的字符串入栈
                ss.push(decoded.toString());
                decoded = new StringBuilder();
                index++;
            } else if (']' == c) {
                // 如果是 ']' 则执行出栈拼接操作
                int repeat = si.pop();
                StringBuilder sb = new StringBuilder(ss.pop());
                for (int i = 0; i < repeat; i++) {
                    sb.append(decoded);
                }
                decoded = sb;
                index++;
            } else {
                // 拼接字符串
                decoded.append(c);
                index++;
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        // String s = "3[a]2[bc]";
        // String s = "3[a2[c]]";
        // String s = "2[abc]3[cd]ef";
        String s = "100[leetcode]";
        DecodeString ds = new DecodeString();
        String[] array = ds.decodeString(s).split("l");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + "\t" + array[i]);
        }
    }

}
