### Trapping Rain Water

> No.42, hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,   
Given `[0,1,0,2,1,0,1,3,2,1,2,1]`, return 6.

![image](https://github.com/procyon-lotor/procyon-lotor.github.io/blob/master/images/2016/rainwatertrap.png?raw=false)

#### 分析

如上图所示，给定一个数组表示各个挡板的高度，每个挡板厚 1 个单位，要求这样的一个容器所能盛的最大雨水数量。这道题目的解题思想就是三次遍历：

1. 第一次从左往右遍历，用一个数组 left 记录各个位置左挡板的最大高度
2. 第二次从右往左遍历，用一个数组 right 记录各个位置右挡板的最大高度
3. 第三次遍历用于计算各个位置所能盛放的雨水量，公式为 min(left[i] - right[i]) - height[i]，需要去掉首尾坐标，因为首尾肯定盛放不住雨水

对于上面的例子计算过程如下：

i | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
height | 0 | 1 | 0 | 2 | 1 | 0 | 1 | 3 | 2 | 1 | 2 | 1
left | 0 | 1 | 1 | 2 | 2 | 2 | 2 | 3 | 3 | 3 | 3 | 3
right | 3 | 3 | 2 | 3 | 3 | 3 | 3 | 3 | 2 | 2 | 2 | 1
result | / | 0 | 1 | 0 | 1 | 2 | 1 | 0 | 0 | 1 | 0 | /

最终结果：1 + 1 + 2 + 1 + 1 = 6

#### 实现

```java
public int trap(int[] height) {
    if (null == height || height.length == 0) return 0;

    // 计算各个位置左挡板的最大高度
    int[] left = new int[height.length];
    int max = left[0] = height[0];
    for (int i = 1; i < height.length; i++) {
        left[i] = Math.max(max, height[i]);
        max = left[i];
    }

    // 计算各个位置右挡板的最大高度
    int[] right = new int[height.length];
    max = right[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
        right[i] = Math.max(max, height[i]);
        max = right[i];
    }

    // 遍历计算各个位置能够蕴含的最大水量，去除首尾，因为首尾不可能装水
    int total = 0;
    for (int i = 1; i < height.length - 1; i++) {
        total += Math.min(left[i], right[i]) - height[i];  // 左右挡板能够蕴含的最大水量 - 不能装水的面积
    }
    return total;
}
```