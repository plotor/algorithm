### Remove Duplicates from Sorted Array II

> No.80, medium

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,  
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

#### 分析

相对于 I 来说，本题对于重复的定义不再是 2 而是 3，也就是说当出现 3 次以上才认为是重复。

这个题目还是比较简单的，主要考虑用一个变量 count 计数，当 count > 2 时才算重复，同时要求重新组织数组，使前面的元素是不重复的。

#### 实现

```java
public int removeDuplicates(int[] nums) {
    if (null == nums) return 0;
    if (nums.length <= 2) return nums.length;
    int pre = nums[0], count = 1, length = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == pre) {
            if (count < 2) {
                length++;
                count++;
            }
        } else {
            pre = nums[i];
            count = 1;
            length++;
        }
        if (i >= length) {
            int tmp = nums[length - 1];
            nums[length - 1] = nums[i];
            nums[i] = tmp;
        }
    }
    return length;
}
```