### Majority Element II

> No.229, medium

Given an integer array of size n, find all elements that appear more than `⌊ n/3 ⌋` times. The algorithm should run in linear time and in O(1) space.

#### 分析

题目要求从给定数组中找出出现次数占比超过 1/3 的元素，还是投票法的应用。

#### 实现

```java
public List<Integer> majorityElement(int[] nums) {
    List<Integer> list = new ArrayList<Integer>();

    // 计算最多的两个元素
    Integer cda = null, cdb = null;
    int cta = 0, ctb = 0;
    for (final int num : nums) {
        if (null != cda && num == cda) {
            cta++;
        } else if (null != cdb && num == cdb) {
            ctb++;
        } else if (cta == 0) {
            cda = num;
            cta++;
        } else if (ctb == 0) {
            cdb = num;
            ctb++;
        } else {
            cta--;
            ctb--;
        }
    }

    // 判断这两个元素的个数是否超过了1/3
    cta = ctb = 0;
    for (final int num : nums) {
        if (cda == num) {
            cta++;
        } else if (cdb == num) {
            ctb++;
        }
    }

    if (cta > nums.length / 3) list.add(cda);
    if (ctb > nums.length / 3) list.add(cdb);

    return list;
}
```
