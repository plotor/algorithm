### Rotate Array

> No.189, easy

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array `[1,2,3,4,5,6,7]` is rotated to `[5,6,7,1,2,3,4]`.

Note:  
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

#### 分析

题目要求给定一个数组，然后向左平移指定的单位，如果这个存储介质是链表则可以采用修改指针的方法，但是这里是数组，所以可以采用几次逆置的操作来达到目的。以题目中的例子来说，大致逆置的过程如下：

编号 | 0 | 1 | 2 | 3 | 4 | 5 | 6 
--- | --- | --- | --- | --- | --- | --- | ---
nums | 1 | 2 | 3 | 4 | 5 | 6 | 7
整体逆置 | 7 | 6 | 5 | 4 | 3 | 2 | 1
局部逆置 | 5 | 6 | 7 | 1 | 2 | 3 | 4


#### 实现

```java
public void rotate(int[] nums, int k) {
    if (null == nums || nums.length == 0) return;
    k = Math.abs(k % nums.length);
    // 先整体逆置，再局部逆置
    this.reverse(nums, 0, nums.length - 1);
    this.reverse(nums, 0, k - 1);
    this.reverse(nums, k, nums.length - 1);
}

// 对数组指定区间执行逆置操作
private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
        start++;
        end--;
    }
}
```