### Reverse Integer

> No.7, easy

Reverse digits of an integer.

```
Example1: x = 123, return 321
Example2: x = -123, return -321
```

Note:  
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

#### 分析

题目的意思是给定一个整数，然后将其逆置，但是不改变正负性。

该题主要考虑的就是 __整数越界问题__，所以先将输入的 int 转换成 long 型，后续针对 long 进行处理即可（题目要求对于越界的情况，返回 0），另外就是考虑负号 “-”，所以可以先将输入统一转换成非负数，最后再处理负号。

```java
 long lx = x < 0 ? -x : x;
```

一开始我用上面的方式将负数转换成正数进行处理，是有问题的，因为上面的操作是将 int 负数转换成 int 正数再转换成 long，所以当 x 是最小负数的时候，转换的过程会出现错误。

#### 实现

```java
/**
 * 题目没有明说，但是当出现越界情况的时候，返回0
 *
 * @param x
 * @return
 */
public int reverse(int x) {
    if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
        return 0;
    }

    long lx = x;  // 考虑越界情况，先转换成long再说

    // 先统一转换成非负数处理
    boolean isNeg = lx < 0 ? true : false;
    lx = isNeg ? -lx : lx;

    long reverse = 0;
    while (lx != 0) {
        long n = lx % 10;
        reverse = reverse * 10 + n;
        lx /= 10;
    }

    if (isNeg) {
        reverse = -reverse < Integer.MIN_VALUE ? 0 : -reverse;
    } else {
        reverse = reverse > Integer.MAX_VALUE ? 0 : reverse;
    }

    return (int) reverse;
}
```
