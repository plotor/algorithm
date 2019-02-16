### Remove Duplicates from Sorted Array

> No.26, easy

Given a __sorted__ array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this __in place with constant memory__.

For example,
Given input array nums = `[1,1,2]`,

Your function should return length = 2, __with the first two elements of nums being 1 and 2__ respectively. It doesn't matter what you leave beyond the new length.

#### 分析

题目要求从一个 __有序__ 的数组中返回非重复元素的个数，保证数组的前n个位置存放不重复的元素，不用考虑后面元素是什么，同时保证空间复杂度是O(1)。

题目规定数组是有序的为这个题目降低了很多难度，这样我们就可以用一个变量记录新发现的一个不重复的值，后面只要与这个值比较，不相同则为新的不重复的元素，但需要注意题目要求必须将不重复的值全部移到数组的前端，而不是仅仅返回一个不重复长度。

#### 实现

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }

    int index = 0;  // 兼记录当前最新发现的不重复元素的个数和目标位置
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[index]) {
            nums[++index] = nums[i];
        }
    }

    return index + 1;
}
```