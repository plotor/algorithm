### Single Number

> No.136, easy

Given an array of integers, every element appears twice except for one. Find that single one.

Note:  
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

#### 分析

题目的意思是给定一个数组，其中除了一个数字以外，其它的数组都出现两次，找出这个数字。

采用异或的思想，因为：

1. 任何两个相同的数字异或结果都是0
2. 0与任何数字异或都等于该数字
3. 异或满足交换律

> - 交换律 A XOR B = B XOR A
> - 结合律 A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
> - 自反性 A XOR B XOR B = A XOR 0 = A

#### 实现

```java
/**
 * 采用异或的思想，因为：
 * 1. 任何两个相同的数字异或结果都是0
 * 2. 0与任何数字异或都等于该数字
 * 3. 异或满足交换律
 *
 * 交换律 A XOR B = B XOR A
 * 结合律 A XOR B XOR C = A XOR (B XOR C) = (A XOR B) XOR C
 * 自反性 A XOR B XOR B = A XOR 0 = A
 *
 * @param nums
 * @return
 */
public int singleNumber(int[] nums) {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
        result ^= nums[i];
    }
    return result;
}
```