package org.zhenchao.algorithm.oj.leetcode.medium;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 92. Restore IP Addresses
 *
 * @author zhenchao.wang 2017-06-28 16:15
 * @version 1.0.0
 */
public class RestoreIpAddresses {

    private List<String> result = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        if (null == s || s.length() < 4 || s.length() > 12) return result;
        this.recursion(s, 0, "");
        return result;
    }

    private void recursion(String s, int count, String prefix) {
        if (count == 3 && this.isValid(s)) result.add(prefix.substring(1) + "." + s);
        for (int i = 0; i < 3 && i < s.length() - 1; i++) {
            String sub = s.substring(0, i + 1);
            if (this.isValid(sub)) {
                this.recursion(s.substring(i + 1, s.length()), count + 1, prefix + "." + sub);
            }
        }
    }

    /**
     * 判断是否是有效的 IP 元素值
     *
     * @param element
     * @return
     */
    private boolean isValid(String element) {
        if (element.startsWith("0")) return element.equals("0");
        int value = Integer.parseInt(element);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddresses ripa = new RestoreIpAddresses();
        ripa.restoreIpAddresses("010010"); // 0.10.0.10, 0.100.1.0
        System.out.println(StringUtils.join(ripa.result, "; "));
    }

}
