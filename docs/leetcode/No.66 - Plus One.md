### Plus One

> No.66, easy

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

#### 分析

题目的意思就是给定一个用数组表示的整数，然后末尾加 1，返回 sum，这个题目只需要注意一点，就是如果给定的数组最后长度增加了 1，则需要重新 new 一个长度加 1 的数组来存放所有的数。

#### 实现

```java
public int[] plusOne(int[] digits) {
    int carry = 1; // 进位
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] == 9 && carry == 1) {
            digits[i] = 0;
            carry = 1;
        } else {
            digits[i] = digits[i] + carry;
            carry = 0;
        }
    }
    int[] result = digits;
    if (carry == 1) {
        // 如果首位进位，则需要重新new一个长度加1的数组
        result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i <= digits.length; i++) {
            result[i] = digits[i - 1];
        }
    }
    return result;
}
```