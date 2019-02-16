package org.zhenchao.algorithm.oj.leetcode.easy

/**
 * @author zhenchao.wang 2019-02-16 14:04
 * @version 1.0.0
 */
class KSumTest extends org.scalatest.FunSuite {

    test("test") {
        val nums = Array(1, 3, 6, 2, 8, 26, 18)
        println(KSum.twoSum(nums, 29).mkString(", "))
    }

}
