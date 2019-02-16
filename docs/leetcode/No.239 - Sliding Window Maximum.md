### 题目

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = `[1,3,-1,-3,5,3,6,7]`, and `k = 3`.

```
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 ```
 
Therefore, return the max sliding window as `[3,3,5,5,6,7]`.

### 分析

题目的意思是给定一个数组，和一个最大窗口长度，记录每个最大窗口中的最大值。

可以借助 __双端队列__ 实现，从第一个元素开始流程如下（队列中存放是数字的下标值，整个过程队列中的数都是非递增排序的）：

> 1. 如果队列为空，或者当前数字小于队列末端的数，则将该数字的下标入队列
> 2. 如果队列非空，且当前数字大于队列中的一部分数，则从最后开始一直往前出队列，直到数字不小于当前值为止，将当前数字的下标入队列
> 3. 检查对首下标是否已经超出最大窗口范围，超出则出队列
> 4. 如果当前下标已经大于等于 k-1，则将对首下标对应的值记录到结果数组中

算法的核心思想是：1) 每一个数组都可能成为窗口范围的最大值，所以每一个数值的下标都会入队列；2) 如果当前值比队列中的一部分值要大，说明这部分值肯定不会成为窗口最大值，直接删掉即可。

### 实现

```java
/**
 * 双端队列法
 *
 * @param nums
 * @param k
 * @return
 */
public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k <= 0) {
        return new int[0];
    }
    // 存放数组下标
    int[] result = new int[nums.length - k + 1];
    // 双端队列
    Deque<Integer> deque = new LinkedList<Integer>();
    for (int i = 0; i < nums.length; i++) {
        // 新的值大于队列中的一部分值
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            // 删除队列中小于当前值的值
            deque.pollLast();
        }
        // 新值入队列
        deque.addLast(i);
        if (i - deque.peekFirst() >= k) {
            // 超出窗口值的元素出队列
            deque.pollFirst();
        }
        if (i >= k - 1) {
            // 开始记录
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }

    return result;
}
```