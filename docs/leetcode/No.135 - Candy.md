### Candy

> No.135, hard

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

#### 分析

题目的意思有 N 个小孩，每一个小孩都有一个权重，现在需要分糖，要保证所有的孩子都能分到糖，同时权重越高的分得越多，算出最少需要多少糖。可以类比 Trapping Rain Water 的解法，采用两个数组 left 和 right 记录当前小孩应得的最小值。



#### 实现

```java
/**
 * 思想上与 Trapping Rain Water 相同
 *
 * @param ratings
 * @return
 */
public int candy(int[] ratings) {
    if (null == ratings || ratings.length == 0) return 0;

    int[] left = new int[ratings.length];
    left[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
        left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
    }

    int[] right = new int[ratings.length];
    right[ratings.length - 1] = 1;
    for (int i = ratings.length - 2; i >= 0; i--) {
        right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
    }

    int total = 0;
    for (int i = 0; i < ratings.length; i++) {
        total += Math.max(left[i], right[i]);
    }
    return total;
}
```
