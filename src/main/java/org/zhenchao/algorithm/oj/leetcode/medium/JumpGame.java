package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * No.55 Jump Game
 *
 * @author zhenchao.wang 2017-05-21 16:12
 * @version 1.0.0
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++) {
            // 计算当前能够到达的最远结点
            max = Math.max(max, i + nums[i]);
            // System.out.println(max);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        // int[] nums = {3, 2, 1, 0, 4};
        // int[] nums = {2, 1, 1, 3, 4};
        // int[] nums = {2, 0, 0};
        int[] nums = {1};
        System.out.println(jg.canJump(nums));
    }

}
