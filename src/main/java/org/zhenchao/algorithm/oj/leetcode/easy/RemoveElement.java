package org.zhenchao.algorithm.oj.leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N0.27
 *
 * @author zhenchao.wang 2016-10-15 11:50:30
 */
public class RemoveElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        RemoveElement re = new RemoveElement();
        int len = re.removeElement(nums, val);
        System.out.println(len);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int right = nums.length - 1;
        for (int left = 0; left <= right; left++) {
            // 保证left始终指向最后一个非目标元素
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            if (nums[left] == val && left < right) {
                nums[left] = nums[right--]; // 无需考虑组织顺序
            }
        }

        return right + 1;
    }

}
