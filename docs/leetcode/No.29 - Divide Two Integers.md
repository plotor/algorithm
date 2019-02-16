### Divide Two Integers

> No.29, medium

Divide two integers without using multiplication, division and mod operator.

__If it is overflow, return `MAX_INT`.__

#### 分析

题目的意思是不能使用乘、除，以及取模操作符，实现两个数之间的取模运算。

题目实际上是考计算机的基本运算，我们都知道计算机是没有乘、除法的，我们平常的乘、除操作最终都还是转换成加、减，以及移位操作来运算，这里我们也可以利用减法来进行除运算，不过每次都减去一个除数的效率太低，所以我们可以在每次减完之后，对除数进行加倍运算（不能乘，还可以通过移位运算嘛）。

#### 实现

```java
/**
 * 不能使用乘、除，取模
 *
 * @param dividend 被除数
 * @param divisor 除数
 * @return
 */
public int divide(int dividend, int divisor) {
    if (dividend == 0 || divisor == 0) return 0;

    // 题目规定溢出时返回MAX_INT
    if (Integer.MIN_VALUE == dividend && divisor == -1) return Integer.MAX_VALUE;

    // 将所有的数字都转成正数进行操作，最后再处理符号
    long dd = dividend, dr = divisor;  // 防止溢出，转成long型操作
    boolean isNag = false;
    if (dd < 0) {
        isNag = !isNag;
        dd = -dd;
    }
    if (dr < 0) {
        isNag = !isNag;
        dr = -dr;
    }
    if (dr > dd) {
        return 0;
    }

    int result = 0;
    while (dd >= dr) {
        long d = dr, x = 0;
        while (dd >= d) {
            dd -= d;
            result += 1 << x++; // 每次减去的除数数量都是上次的一倍
            d = d << 1;  // 除数加倍
        }
    }
    return isNag ? -result : result;
}
```