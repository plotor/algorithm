package org.zhenchao.algorithm.oj.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 *
 * @author zhenchao.wang 2017-09-16 15:07
 * @version 1.0.0
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        // 计算最多的两个元素
        Integer cda = null, cdb = null;
        int cta = 0, ctb = 0;
        for (final int num : nums) {
            if (null != cda && num == cda) {
                cta++;
            } else if (null != cdb && num == cdb) {
                ctb++;
            } else if (cta == 0) {
                cda = num;
                cta++;
            } else if (ctb == 0) {
                cdb = num;
                ctb++;
            } else {
                cta--;
                ctb--;
            }
        }

        // 判断这两个元素的个数是否超过了1/3
        cta = ctb = 0;
        for (final int num : nums) {
            if (cda == num) {
                cta++;
            } else if (cdb == num) {
                ctb++;
            }
        }

        if (cta > nums.length / 3) list.add(cda);
        if (ctb > nums.length / 3) list.add(cdb);

        return list;
    }

    public static void main(String[] args) {
        MajorityElementII me = new MajorityElementII();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(me.majorityElement(nums));
    }

}
