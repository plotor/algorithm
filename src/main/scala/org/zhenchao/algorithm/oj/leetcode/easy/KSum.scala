package org.zhenchao.algorithm.oj.leetcode.easy

/**
 * @author zhenchao.wang 2019-02-16 14:01
 * @version 1.0.0
 */
object KSum {

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        if (null != nums) {
            val array = nums.zipWithIndex.sorted
            var l = 0
            var r = nums.length - 1
            while (l < r) {
                val sum = array(l)._1 + array(r)._1
                if (sum > target) {
                    r -= 1
                } else if (sum < target) {
                    l += 1
                } else {
                    return Array(array(l)._2, array(r)._2)
                }
            }
        }
        null
    }
}
