### Count Primes

> No.204, easy

Description:

Count the number of prime numbers less than a non-negative number, n.

#### 分析

#### 实现

```java
/**
 * 基于埃拉托斯特尼筛法
 *
 * @param n
 * @return
 */
public int countPrimes(int n) {
    boolean[] mask = new boolean[n];
    Arrays.fill(mask, true);
    for (int i = 2; i < n; i++) {
        if (!mask[i]) {
            continue;
        }
        for (int j = i * 2; j < n; j += i) {
            mask[j] = false;
        }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
        if (mask[i]) count++;
    }
    return count;
}
```
