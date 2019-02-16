### Palindrome Number

> No.9, easy

Determine whether an integer is a palindrome. Do this without extra space.

#### 分析

题目要求判断一个数字是不是回文数字，空间复杂度要求为 O(1)，所以不能将整个数调过来判断是否与原数大小相同。

我们可以按照回文数字的定义，从两边开始向中间，依次比较对应的数字是否相等，这样就需要一开始就有一个除数，用来依次取首部的数字，因为不能使用额外的空间，所以这个数字在构建的时候有点技巧，另外一点就是负数不是回文数。

#### 实现

```java
public boolean isPalindrome(int x) {
    if (x < 0) return false;  // 负数不是回文
    if (x >= 0 && x <= 9) return true;

    // 构建除数
    int divider = 1;
    while (x / divider >= 10) divider *= 10;

    // 比对校验
    while (x > 0) {
        if (x / divider != x % 10) {
            return false;
        }
        x %= divider;
        x /= 10;
        divider /= 100;
    }

    return true;
}
```
