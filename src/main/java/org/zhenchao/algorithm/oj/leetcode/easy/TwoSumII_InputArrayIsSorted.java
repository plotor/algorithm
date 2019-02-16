package org.zhenchao.algorithm.oj.leetcode.easy;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * @author zhenchao.wang 2017-09-10 13:33
 * @version 1.0.0
 */
public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }

}
