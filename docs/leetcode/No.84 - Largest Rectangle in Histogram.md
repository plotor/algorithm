### Largest Rectangle in Histogram

> No.84, hard

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![image](https://leetcode.com/static/images/problemset/histogram.png)

Above is a histogram where width of each bar is 1, given height = `[2,1,5,6,2,3]`.

![image](https://leetcode.com/static/images/problemset/histogram_area.png)

The largest rectangle is shown in the shaded area, which has area = `10` unit.

For example,  
Given heights = [2,1,5,6,2,3],  
return 10.

#### 分析

题目给定一个直方图，每个 bar 的宽度为 1 ，要求从中找出连续的若干个 bar，以最矮的那个 bar 的高度为准，求能够组成的最大面积。

这道题目最简单的做法就是利用两个 for 循环逐个遍历，但是这样时间复杂度为 O(n^2^)，所以不可取。另外一种解题思路是引入一个栈，栈中始终存放大于当前栈顶位置对应元素值元素的索引值。

![image](http://images.cnitblog.com/blog/466943/201307/17223405-ba207c5828a54eca8ca81e04175aa3bd.png)

可以借助上图进行理解，例如我们遇到最后一个递减的 bar（红色）。高度位于红线上方的（也就是算法中栈里面大于最右 bar 的）元素，他们是不可能和最右边的较小高度 bar 围成一个大于在出栈过程中的矩形面积的（黄色面积），因为红色的 bar 对他们来说是一个短板，和红色 bar 能围成的最大面积也就是红色的高度乘以这些 “上流社会” 所跨越的索引范围。但是 “上流社会” 的高度个个都比红色 bar 大，他们完全只计算彼此之间围成的面积就远远大于和红色 bar 围成的任意面积。所以红色 bar 是不可能参与 “上流社会” 的 bar 的围城的（好悲哀）。

但是屌丝也不用泄气哦，因为虽然长度不占优势，但是团结的力量是无穷的。它还可以参与 “比较远的” 比它还要屌丝的 bar 的围城。他们的面积是有可能超过上流社会的面积的，因为距离啊！所以出栈到比红色 bar 小就停止了。

另外一个细节需要注意的是，出栈过程中面积的计算：

```
h[p] * (stack.isEmpty() ? i : i - stack.peek() - 1)
```

h[p] 是刚刚出栈的栈顶端元素，此时的面积计算是 h[p] 和前面的 “上流社会” 能围成的最大面积，这时候要注意栈内索引指向的元素都是比 h[p] 小的，如果 h[p] 是目前最小的，那么栈内就是空的，而在目前栈顶元素和 h[p] 之间（不包括 h[p] 和栈顶元素），都是大于他们两者的。如下图所示：

![image](http://images.cnitblog.com/blog/466943/201307/18095649-645e12c5653440f2a9e2ca7b505a3082.png)

那 h[p] 无疑就是 stack.peek() 和 p 之间那些上流社会的短板啦，而它们的跨越就是 i - stack.peek() - 1。

所以说，这个出栈的过程也是维持程序不变量的方法：栈内元素一定是要比当前 i 指向的元素小。

#### 实现

```java
public int largestRectangleArea(int[] heights) {
    int max = 0;
    if (null == heights || 0 == heights.length) {
        return max;
    }

    // 栈中始终存放比当前栈顶元素值大的元素的索引
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < heights.length; ) {
        if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
            // 针对比栈顶元素大的元素，直接入栈
            stack.push(i++);
        } else {
            int p = stack.pop();
            int h = heights[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }
    }

    while (!stack.isEmpty()) {
        int p = stack.pop();
        int h = heights[p];
        int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
        max = Math.max(max, h * w);
    }

    return max;
}
```
