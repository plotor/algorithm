### Sqrt(x)

> No.69, easy

Implement `int sqrt(int x)`.

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:

```
Input: 4
Output: 2
```

Example 2:

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
```

#### 分析

题目的意思是实现一个 __开方__ 函数，如果结果不是整型，则向下取整。

这道题目可以采用 __二分查找__ 进行求解，每次查找一个数，就判断其平方值是否等于目标值，过程中需要注意整型溢出的问题。

#### 实现

```java
public int mySqrt(int x) {
    int left = 0, right = x;
    while (left <= right) {
        long mid = (left + right) / 2; // mid可能会溢出，需要用long型
        long sq = mid * mid;
        if (sq == x) {
            return (int) mid;
        } else if (sq < x) {
            left = (int) (mid + 1);
        } else {
            right = (int) (mid - 1);
        }
    }
    // 这里一定要返回right
    return right;
}
```
