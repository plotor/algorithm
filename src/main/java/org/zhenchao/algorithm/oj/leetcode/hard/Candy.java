package org.zhenchao.algorithm.oj.leetcode.hard;

/**
 * 135. Candy
 *
 * @author zhenchao.wang 2017-08-13 11:59
 * @version 1.0.0
 */
public class Candy {

    /**
     * 思想上与 Trapping Rain Water 相同
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (null == ratings || ratings.length == 0) return 0;

        int[] left = new int[ratings.length];
        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }

        int[] right = new int[ratings.length];
        right[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
        }

        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += Math.max(left[i], right[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratting = {1, 2};
        System.out.println(candy.candy(ratting));
    }

}
