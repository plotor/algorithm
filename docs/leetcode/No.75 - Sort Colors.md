### Sort Colors

> No.75, medium

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

__Note:__

You are not suppose to use the library's sort function for this problem.

#### 分析

题目的意思是给定一个数组，仅包含 0， 1， 2 三种元素，分别代表红、白、蓝三种颜色，题目要求在不借助排序算法的前提下就，将数组中所有的元素按照红白蓝的顺序排序。

- 思路一

比较好的思路是用三个指针：l、r、index，保证 l 所指向位置的左边全是0，r 所指向位置的右边全是 2，然后在 index 从 l 到 r 进行遍历，如果是 0 则与 l 位置进行元素交换，如果是 2 则与 r 位置进行元素交换，如果是 1 则不管，直到 index 移动到 r 位置，注意控制好边界，防止溢出。

- 思路二

我们可以遍历一遍数组，然后分别记录下 0、1、2 的数目，然后重新复写数组元素即可，这是一个比较讨巧的方法。

#### 实现

- 思路一

```java
public void sortColors(int[] nums) {
    // if (null == nums || 0 == nums.length || 1 == nums.length) return;
    int l = 0, index = l, r = nums.length - 1;
    while (index <= r) {
        while (l < r && nums[l] == 0) {
            l++;
            index++;
        }
        while (r > l && nums[r] == 2) {
            r--;
        }
        if (l < r && nums[index] == 0) {
            int tmp = nums[l];
            nums[l] = nums[index];
            nums[index] = tmp;
            l++;
        } else if (r > l && nums[index] == 2) {
            int tmp = nums[r];
            nums[r] = nums[index];
            nums[index] = tmp;
            r--;
        } else {
            index++;
        }
    }
}
```

- 思路二

略