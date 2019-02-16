package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenchao.wang 2017-06-07 20:33
 * @version 1.0.0
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        // 格式化处理
        path = path.replaceAll("/+", "/");
        if (path.length() > 1 && path.endsWith("/")) path = path.substring(0, path.length() - 1);

        // 遍历处理每个元素
        String[] elements = path.substring(1).split("/");
        List<String> list = new ArrayList<String>();
        for (final String element : elements) {
            if (".".equals(element)) continue;
            if ("..".equals(element)) {
                if (list.size() == 0) {
                    // 当前置溢出时，算作“/”
                    continue;
                }
                list.remove(list.size() - 1);
            } else {
                list.add(element);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (final String str : list) {
            sb.append(str).append("/");
        }
        return "/" + (sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/.."));
    }

}
