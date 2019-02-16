### Majority Element

> No.169, easy

Given an array of size n, find the majority element. The majority element is the element that appears more than `⌊ n/2 ⌋` times.

You may assume that the array is non-empty and the majority element always exist in the array.

#### 分析

题目要求从给定数组中找出出现次数占比超过 1/2 的元素，最容易想到的方法就是对数组进行排序，然后返回最中间的结点即可，另外一种称之为 __投票法__。

#### 实现

```java
/**
 * 解法一：直接对数组进行排序，然后选择最中间的数字
 *
 * @param nums
 * @return
 */
public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
}

/**
 * 解法二：投票法
 *
 * @param nums
 * @return
 */
public int majorityElement2(int[] nums) {
    int count = 0, result = nums[0];
    for (int i = 0; i < nums.length; i++) {
        if (count == 0) {
            result = nums[i];
            count++;
        } else if (result == nums[i]) {
            count++;
        } else {
            count--;
        }
    }
    return result;
}
```