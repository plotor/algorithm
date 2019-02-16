### Factorial Trailing Zeroes

> No.172, easy

Given an integer n, return the number of trailing zeroes in `n!`.

Note: Your solution should be in logarithmic time complexity.

#### 分析

#### 实现

```java
/**
 * 求 n! 末尾 0 的个数
 * 可以将一个 0 分解为 10， 10 = 2 × 5，于是就是 min(2, 5)， 显然 5 的个数更少，所以最终就是转换成求 5 的个数
 *
 * @param n
 * @return
 */
public int trailingZeroes(int n) {
    int count = 0;
    while (n / 5 > 0) {
        count += n / 5;
        n /= 5;
    }
    return count;
}
```
