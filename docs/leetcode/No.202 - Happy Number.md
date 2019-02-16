### Happy Number

> No.202, easy

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

```
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

#### 分析

#### 实现

```java
public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<Integer>();
    while (true) {
        if (1 == n) return true;
        if (set.contains(n)) return false;
        set.add(n);
        n = this.sum(n);
    }
}

private int sum(int num) {
    int sum = 0;
    while (num > 0) {
        sum += Math.pow(num % 10, 2);
        num /= 10;
    }
    return sum;
}
```
